import { Component, OnInit } from '@angular/core';
import { Horario } from '@horario/shared/model/horario';
import { HorarioService } from '@horario/shared/service/horario.service';

@Component({
  selector: 'app-listar-horario',
  templateUrl: './listar-horario.component.html',
  styleUrls: ['./listar-horario.component.css']
})
export class ListarHorarioComponent implements OnInit {

  flagHorarios: boolean = false;

  dataSource: Horario[] = [];
  displayedColumns = ['nombre_clase', 'dia', 'hora_inicio', 'cantidad_horas', 'accion'];

  constructor(private horarioService: HorarioService) { }

  ngOnInit() {
    this.horarioService.consultar().subscribe(horarios =>{
      if(horarios.length>0){
        this.dataSource = horarios;
        this.flagHorarios = true;
      }
    });
  }

  eliminar(horario: Horario){
    this.horarioService.eliminar(horario).subscribe( () =>{
      this.dataSource = this.dataSource.filter(x => x.id!=horario.id);
      (this.dataSource.length<1)? this.flagHorarios=false : this.flagHorarios=true ;
    });
  }

}
