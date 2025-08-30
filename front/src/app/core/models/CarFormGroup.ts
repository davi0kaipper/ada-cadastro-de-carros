import { FormControl } from "@angular/forms";
import { Brand } from "./Brand";
import { Model } from "./Model";
import { TransmissionType } from "./TransmissionType";

export type CarFormGroup = {
    brand: FormControl<Brand | null>;
    model: FormControl<Model | null>;
    color: FormControl<string | null>;
    transmission: FormControl<TransmissionType | null>;
    year: FormControl<number | null>;
    price: FormControl<number | null>;
}