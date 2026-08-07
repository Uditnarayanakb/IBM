function TransactionHistory({
  transactions,
}) {
  return (
    <>
      <h2 className="history-title">
        Transaction History
      </h2>

      {transactions.length === 0 ? (
        <p className="empty-history">
          No Transactions Yet
        </p>
      ) : (
        transactions.map(
          (transaction, index) => (
            <div
              key={index}
              className="transaction-card"
            >
              <span
                className={
                  transaction.type
                  === "Deposit"
                    ? "deposit-text"
                    : "withdraw-text"
                }
              >
                {transaction.type ===
                "Deposit"
                  ? `↗ Deposit ₹${transaction.amount}`
                  : `↘ Withdraw ₹${transaction.amount}`}
              </span>

              <span className="remaining-balance">
                Balance ₹
                {
                  transaction.remainingBalance
                }
              </span>
            </div>
          )
        )
      )}
    </>
  );
}

export default TransactionHistory;