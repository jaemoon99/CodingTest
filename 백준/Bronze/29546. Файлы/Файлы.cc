#include <bits/stdc++.h>

using namespace std;

typedef vector<string> vs;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n; cin >> n;

  vs photos(n);
  for (int i = 0; i < n; i++)
    cin >> photos[i];

  int m; cin >> m;
  for (int i = 0; i < m; i++) {
    int l, r; cin >> l >> r;

    for (int j = l - 1; j < r; j++)
      cout << photos[j] << "\n";
  }

  return 0;
}