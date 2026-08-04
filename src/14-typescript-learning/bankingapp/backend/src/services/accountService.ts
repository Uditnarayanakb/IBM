import { Account } from "../models/account";

const account: Account = {
    accountNumber: 101,
    accountHolderName: "Udit",
    balance: 10000
};

export const deposit = (amount: number): Account => {

    account.balance += amount;

    return account;
};

