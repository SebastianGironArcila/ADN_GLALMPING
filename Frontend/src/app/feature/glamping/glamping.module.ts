import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { GlampingService } from './shared/service/glamping.service';


@NgModule({
    declarations:[

    ],
    imports: [
        SharedModule
    ],
    providers:[GlampingService]
})

export class GlampingModule{}