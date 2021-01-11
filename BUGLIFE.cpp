#include <bits/stdc++.h>
using namespace std;
int main(){
    int t;
    int b, in, b1, b2, g1, g2;
    cin >> t;
    int cnt = 1;
    while(t >= cnt) {
        cin >> b >> in;
        vector<int> v(b + 1, 0);
        bool flag = false;
        for(int itr = 0 ; itr < in ; itr++) {
            cin >> b1 >> b2;
            g1 = v[b1];
            g2 = v[g2];
            if(g1 == 0 && g2 == 0) {
                v[b1] = 1;
                v[b2] = 2;
            } else if(v[b1] == 0) {
                v[b1] = (v[b2] == 1) ? 2 : 1;
            } else if(v[b2] == 0) {
                v[b2] = (v[b1] == 1) ? 2 : 1;
            } else {
                if(v[b1] == v[b2]) {
                    flag = true;
                }
            }
        }
        cout << "\nScenario #" << cnt++ << ":\n";
        // for(int ele: v) {
        //     cout << ele << " ";
        // }
        if(flag) {
            cout << "Suspicious bugs found!";
        } else {
             cout << "No suspicious bugs found!";
        }
    }
}