package com.tan.jdk.clone;

public class City implements Cloneable{
	 private String name;

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    public City(String name) {
	        super();
	        this.name = name;
	    }

	    @Override
	    public City clone() throws CloneNotSupportedException {
	        return (City) super.clone();
	    }

	    @Override
	    public String toString() {
	        return "City [name=" + name + "]";
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        City other = (City) obj;
	        if (name == null) {
	            if (other.name != null)
	                return false;
	        } else if (!name.equals(other.name))
	            return false;
	        return true;
	    }
}
