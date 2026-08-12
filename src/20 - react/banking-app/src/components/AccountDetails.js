import { useEffect, useState } from "react";
import { fetchAccountDetails } from "../api";

function AccountDetails() {
  const [account, setAccount] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    let isMounted = true;

    fetchAccountDetails()
      .then((data) => {
        if (!isMounted) return;
        setAccount(data);
        setLoading(false);
      })
      .catch((err) => {
        if (!isMounted) return;
        setError(err.message || "Failed to load account details");
        setLoading(false);
      });

    return () => {
      isMounted = false;
    };
  }, []);

  if (loading) {
    return <div>Loading account details...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div>
      <h2>Account Details</h2>
      <div>
        <strong>Name:</strong> {account.name}
      </div>
      <div>
        <strong>Email:</strong> {account.email}
      </div>
      <div>
        <strong>Phone:</strong> {account.phone}
      </div>
      <div>
        <strong>Company:</strong> {account.company?.name}
      </div>
      <div>
        <strong>Address:</strong> {account.address?.street}, {account.address?.city}
      </div>
    </div>
  );
}

export default AccountDetails;
