import { Component, OnInit } from '@angular/core';
import { MainService } from '../service/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private province :any;
  //item: Array <any>;
  transport: Array <any>;

  cus : any ={
    id : '',
    username : '',
    customerName : '',
    tel : '',
    email : ''
  };

  item: any = {
    itemId: '',
    itemName: '',
    price: '',
    numItem: ''
  };


  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute){}

  ngOnInit() {
    this.rout.params.subscribe(prams=>{
        this.province = prams
        console.log(prams)
    })

    this.mainService.getItem().subscribe(data => {
      this.item = data;
      console.log(this.item);
    });

  }

  add(itemId,itemNum){
    this.router.navigate(['transport/' + itemId,{itemId:itemId, itemNum:itemNum}]);
  }

}
