export class TransmissionTypes {
    public static cases: TransmissionType[] = [
        { value: 'MANUAL', presentableName: 'Manual' },
        { value: 'AUTOMATICO', presentableName: 'Automático' }
    ];
}

export type TransmissionType = { value: string, presentableName: string }