import { Component, OnInit } from '@angular/core';
import { MainService } from '../service/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delivery3',
  templateUrl: './delivery3.component.html',
  styleUrls: ['./delivery3.component.css']
})
export class Delivery3Component implements OnInit {

  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
  }
   next(){
  this.router.navigate(['infomation_final/']);
  }
}
