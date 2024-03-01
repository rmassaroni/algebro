#include <iostream>

using namespace std;

class Variable {
public:
    Variable(string name = "", int value = 1);
private:
    string name;
    int value;
};

Variable::Variable(string name, int value) {
    this->name = name;
    this->value = value;
}

int main() {
    cout << "test" << endl;
    return 0;
};
