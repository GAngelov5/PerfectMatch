package services;

import java.util.Comparator;
import java.util.Map;

import models.User;

class ValueComparator implements Comparator<User> {

    Map<User, Integer> base;
    
    public ValueComparator(Map<User,Integer> base) {
    	this.base = base;
    }

    @Override
    public int compare(User a, User b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }

}