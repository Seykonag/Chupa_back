#include <iostream>

using namespace std;

class User {
private: 
	string name;
	unsigned id;


public:
	User(string name, int id) {
		this->name = name;
		this->id = id;
	}

	void getInfo() {
		cout << "Имя пользователя: " << name << ". Айди пользователя: " << id;
	}

};

void main() {
	User* user = new User("Olga", 15);

	delete user;
}