//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {

public:

    bool isCyclic(int V, vector<vector<int>>& edges) {

        // Build adjacency list

        unordered_map<int, vector<int>> adj;

        for (const auto& edge : edges) {

            int u = edge[0];

            int v = edge[1];

            adj[u].push_back(v);

        }

 

        vector<bool> visited(V, false);

        vector<bool> recStack(V, false);

 

        for (int i = 0; i < V; ++i) {

            if (!visited[i] && isCyclicUtil(i, adj, visited, recStack)) {

                return true;

            }

        }

 

        return false;

    }

 

private:

    bool isCyclicUtil(int v, unordered_map<int, vector<int>>& adj, vector<bool>& visited, vector<bool>& recStack) {

        if (!visited[v]) {

            visited[v] = true;

            recStack[v] = true;

 

            for (int neighbor : adj[v]) {

                if (!visited[neighbor] && isCyclicUtil(neighbor, adj, visited, recStack)) {

                    return true;

                } else if (recStack[neighbor]) {

                    return true;

                }

            }

        }

 

        recStack[v] = false;

        return false;

    }

};


//{ Driver Code Starts.

int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        int V, E;
        cin >> V >> E;
        cin.ignore();
        vector<vector<int>> edges;
        for (int i = 1; i <= E; i++) {
            int u, v;
            cin >> u >> v;
            edges.push_back({u, v});
        }

        Solution obj;
        bool ans = obj.isCyclic(V, edges);
        if (ans)
            cout << "true\n";
        else
            cout << "false\n";
    }
    return 0;
}
// } Driver Code Ends