import { Directive, HostListener } from '@angular/core';

@Directive({
    selector: '[appDarkenOnHover]'
})
export class DarkenOnHoverDirective {

    @HostListener('mouseover')
    darkenOn() {
        console.log('darkenOn');
    }

    @HostListener('mouseleave')
    darkenOff() {
        console.log('darkenOff')
    }

}
