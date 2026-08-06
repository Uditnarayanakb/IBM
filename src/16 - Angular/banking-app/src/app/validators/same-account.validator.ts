import {
  AbstractControl,
  ValidationErrors
} from '@angular/forms';

export function sameAccountValidator(
  control: AbstractControl
): ValidationErrors | null {

  const from =
    control.get('fromAccount')?.value;

  const to =
    control.get('toAccount')?.value;

  if (from === to) {

    return {
      sameAccount: true
    };

  }

  return null;
}