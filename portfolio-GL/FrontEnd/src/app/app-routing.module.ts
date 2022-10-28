import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditHeaderComponent } from './components/header/edit-header.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditSkillComponent } from './components/skills/edit-skill.component';
import { NewSkillComponent } from './components/skills/new-skill.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editexp/:id', component: EditExperienciaComponent},
  {path:'nuevaedu', component:NewEducacionComponent },
  {path:'editedu/:id', component: EditEducacionComponent},
  {path:'nuevaskill', component: NewSkillComponent},
  {path:'editskill/:id', component: EditSkillComponent},
  {path:'editheader/:id', component: EditHeaderComponent}
  //falta componente para el registro
  //{path: '', redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
