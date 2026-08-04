import express from "express";

import * as accountController
from "../controllers/accountController";

const router = express.Router();

router.post(
    "/deposit",
    accountController.depositMoney
);

export default router;