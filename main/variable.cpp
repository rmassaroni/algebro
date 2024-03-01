#include <iostream>

using namespace std;

class Variable {
public:
    Variable(string name = "", int value = 1, int coefficient = 1);
private:
    string name;
    int value;
    int coefficient;
};

Variable::Variable(string name, int value, int coefficient) {
    this->name = name;
    this->value = value;
}

int main() {
    cout << "test" << endl;
    return 0;
};
