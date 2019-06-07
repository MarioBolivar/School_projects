#include "InventoryClass.h"

int InventoryItem::number_articles = 0;

//overloaded constructor
InventoryItem::InventoryItem(char *desc,double c, int u){

    number_articles++;
    description = desc;
    cost = c;
    units = u;
}

void InventoryItem::setDescription(char *desc){
    description = desc;
}

const char* InventoryItem::getDescription() const{
    const char* c = description;
    return c;
}

void InventoryItem::setCost(double c){
    cost = c;
}

double InventoryItem::getCost() const{
    return cost;
}

void InventoryItem::setUnits(int u){
    units = u;
}

int InventoryItem::getUnits() const{
    return units;
}

int InventoryItem::getNumArticles() const{
    return number_articles;
}

//destructor
InventoryItem::~InventoryItem(){

}