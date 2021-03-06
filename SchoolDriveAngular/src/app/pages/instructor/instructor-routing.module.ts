import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SearchInstructorComponent} from "./components/search-instructor/search-instructor.component";
import {InstructorDetailsComponent} from "./components/instructor-details/instructor-details.component";
import {RateInstructorComponent} from "./components/rate-instructor/rate-instructor.component";

const routes: Routes = [
  { path: "", redirectTo: "search", pathMatch: "full" },
  { path: "search", component: SearchInstructorComponent },
  { path: "instructor-details/:id", component: InstructorDetailsComponent },
  { path: "rate-instructor/:id", component: RateInstructorComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InstructorRoutingModule { }
