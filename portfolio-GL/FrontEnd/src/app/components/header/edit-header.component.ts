import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-edit-header',
  templateUrl: './edit-header.component.html',
  styleUrls: ['./edit-header.component.css']
})
export class EditHeaderComponent implements OnInit {
  persona: persona = null;

  constructor(private personaService: PersonaService, private activatedRouted: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouted.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
      data=>{
        this.persona = data;
      }, err=>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate():void{
    const id = this.activatedRouted.snapshot.params['id'];
    this.personaService.update(id, this.persona).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al modificar campos");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any){

  }
}
