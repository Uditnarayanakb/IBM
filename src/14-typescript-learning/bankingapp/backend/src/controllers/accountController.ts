import * as accountService from "../services/accountService";

export const depositMoney = (
    req: any,
    res: any
) => {

    const amount = req.body.amount;

    const account =
        accountService.deposit(amount);

    res.json(account);
};