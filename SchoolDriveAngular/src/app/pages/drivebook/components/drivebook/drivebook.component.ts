import {Component, Input, OnInit} from '@angular/core';
import {DriveBookingPresentation} from "../../../../classes/drive-booking-presentation";
import {DateUtilsService} from "../../../../service/date-utils.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-drivebook',
  templateUrl: './drivebook.component.html',
  styleUrls: ['./drivebook.component.scss']
})
export class DrivebookComponent implements OnInit {

  @Input()
  drive: DriveBookingPresentation;

  constructor(
    private dateUtils: DateUtilsService,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  //funkcja zamieniająca pierwszą literę każdego słowa na wielką i zwracająca słowa oddzielone spacją
  capitalizeFirstLetters(...words: string[]) {
    let capitalized;
    capitalized = words.reduce((prev, curr) => {
      return prev.concat(curr.charAt(0).toUpperCase() + curr.substr(1).toLowerCase() + " ");
    }, "");
    return capitalized.substr(0, capitalized.length-1);
  }

  convertTimeToHoursAndMinutes(date: string): string {
    return this.dateUtils.convertTimeToHoursAndMinutes(date);
  }

  goToDetails(id: number) {

    if(this.dateUtils.compareWithToday(this.drive.day)) {
      this.router
        .navigate(['pages/drivebooks/incoming', id]);
    } else {
      this.router
        .navigate(['pages/drivebooks/historical', id]);
    }
  }
}
