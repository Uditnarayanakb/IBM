const API_BASE_URL = "https://jsonplaceholder.typicode.com";

export async function fetchAccountDetails() {
  const response = await fetch(`${API_BASE_URL}/users/1`);
  if (!response.ok) {
    throw new Error("Failed to fetch account details");
  }
  return response.json();
}
