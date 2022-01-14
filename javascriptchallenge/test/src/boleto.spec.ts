import { Boleto } from '../../src/boleto';

describe(`Boleto object`, () => {

    beforeAll(() => {
    });

    afterEach(() => {

    });

    it(`should create a boleto object successfully`, () => {
        let boleto = new Boleto('2022-01-14', 127.93, 'Our Company');
        let expected = {
            dueDate: '2022-01-14',
            amount: 127.93,
            beneficiary: 'Our Company'
        }
        expect(boleto).toEqual(expected);
    });
});
