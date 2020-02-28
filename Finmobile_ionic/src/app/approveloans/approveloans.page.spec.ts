import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ApproveloansPage } from './approveloans.page';

describe('ApproveloansPage', () => {
  let component: ApproveloansPage;
  let fixture: ComponentFixture<ApproveloansPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveloansPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ApproveloansPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
