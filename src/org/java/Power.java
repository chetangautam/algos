package org.java;

public class Power {

	public double power(int x, int y) {
		double result = 1;
		if (y>0){
			for(int i=1; i<=y; ++i) {
				result = result *x;
			}
		} else if(y==0) {
			result = 1;
		} else {
			y = -y;
			for(int i=1; i<=y; ++i) {
				result = result *x;
			}
			result = 1/result;
		}
		return result;
	}

	public long powerFast(int x, int y) {
		long result = 1;
		if (y<0){
			y = -y;
			for(int i=1; i<=y/2; ++i) {
				result = result *x;
			}
			if (y%2 == 0) {
				result = result * result;
			} else {
				result = x * result * result;
			}
			result = 1/result;
		} else if(y==0) {
			result = 1;
		} else {
			for(int i=1; i<=y/2; ++i) {
				result = result *x;
			}
			if (y%2 == 0) {
				result = result * result;
			} else {
				result = x * result * result;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Power p = new Power();
		System.out.println(p.power(3,5));
		System.out.println(p.power(-5,3));
		System.out.println(p.pow(3,5));
		System.out.println(p.pow(-5,3));
		System.out.println(p.powerFast(3,5));
		System.out.println(p.powerFast(-5,3));
		System.out.println(p.powerFast(3,4));
		System.out.println(p.powerFast(-5,4));
		System.out.println(p.powFast(3,4));
		System.out.println(p.powFast(-5,4));
	}

	public double powRec(int x, int y) {
		if (y<0) {
			return 1/pow(x,-y);
		} else {
			return pow(x,y);
		}
	}

	public long pow(int x, int y) {
		if (y==0) {
			return 1;
		}
		return x*pow(x, y-1);
	}

	public double powFastRec(int x, int y) {
		if (y<0) {
			return 1/powFast(x,-y);
		} else {
			return powFast(x,y);
		}
	}

	public long powFast(int x, int y) {
		if (y==0) {
			return 1;
		}
		if (y %2 == 0) {
			return powFast(x, y/2) * powFast(x, y/2);
		} else {
			return x * powFast(x, y-1);
		}
	}
}
