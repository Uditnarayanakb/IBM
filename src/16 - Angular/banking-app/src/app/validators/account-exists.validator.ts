import {
  AbstractControl,
  AsyncValidatorFn
} from '@angular/forms';

import { of } from 'rxjs';

import {
  delay,
  map
} from 'rxjs/operators';

export function accountExistsValidator():
AsyncValidatorFn {

  return (
    control: AbstractControl
  ) => {

    const validAccounts = [

      'ACC101',
      'ACC102',
      'ACC103'

    ];

    return of(

      validAccounts.includes(
        control.value
      )

    ).pipe(

      delay(1000),

      map(exists =>

        exists
          ? null
          : { accountNotFound: true }

      )

    );

  };

}