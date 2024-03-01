#include <iostream>

using namespace std;

class Variable {
public:
    Variable();
    Variable(string s);
private:
    string name;
};

Variable::Variable() {
    name = "";
}

Variable::Variable(string s) {
    name = s;
}


int main() {
    cout << "test" << endl;
    return 0;
};
