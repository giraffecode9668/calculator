package calculater;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class Action	{
	
	public static  String firstD(String temp) {
		StringBuilder tempp = new StringBuilder(temp);
		int a = tempp.indexOf("(");
		int b = tempp.indexOf(")");
		while (a >= 0 && b >= 0) {
			while (true) {
				int c = a;
				a = tempp.indexOf("(", a + 1);
				if (a == -1) {
					a = c;
					break;
				}
			} // 双括号里边的括号
			String temppp = getStrings(tempp.toString(), a + 1, b - 1);
			tempp.replace(a, b + 1, cal(temppp));

			a = tempp.indexOf("(");
			b = tempp.indexOf(")");
		}
		return handle(tempp.toString());
	}

	public static String handle(String temp) {

		try {
			double change = Double.valueOf(cal(temp));
			change = ((int)(change * 10000))/10000.0;
			if(WebOfScience.isFe) {
				return getFe(String.valueOf(change));
			}else return String.valueOf(change);
		}catch(Exception e) {
			return "0";
		}
		
	}

	// 消除运算
	static String cal(String temp) {
		// 消除deg计算;
		if (temp.indexOf("degrees") >= 0) {
			temp = dt("degrees", temp);
		}
		// 消除dms计算
		if (temp.indexOf("dms") >= 0) {
			temp = dt("dms", temp);
		}
		// 消除%号
		if (temp.indexOf("%") >= 0) {
			temp = dt("%", temp);
		}
		// 消除阶乘
		if (temp.indexOf("!") >= 0) {
			temp = dt("!", temp);
		}
		//消除ln计算
		if (temp.indexOf("ln") >= 0) {
			temp = dt("ln", temp);
		}
		// 消除log计算
		if (temp.indexOf("log") >= 0) {
			temp = dt("log", temp);
		}
		// 消除Exp计算
		if (temp.indexOf("E") >= 0) {
			temp = dt("E", temp);
		}
		// 消除Mod计算
		if (temp.indexOf("Mod") >= 0) {
			temp = dt("Mod", temp);
		}
		// 消除Se计算(平方)
		if (temp.indexOf("sqr") >= 0) {
			temp = dt("sqr", temp);
		}
		//消除Cb计算(立方)
		if (temp.indexOf("cube") >= 0) {
			temp = dt("cube", temp);
		}
		// 消除根号
		if (temp.indexOf("√") >= 0) {
			temp = dt("√", temp);
		}
		//消除开n次方
		if (temp.indexOf("yroot") >= 0) {
			temp = dt("yroot", temp);
		}
		//消除sin^-1计算
		if (temp.indexOf("sin^-1") >= 0) {
			temp = dt("sin^-1", temp);
		}
		//消除cos^-1计算
		if (temp.indexOf("cos^-1") >= 0) {
			temp = dt("cos^-1", temp);
		}
		//消除tan^-1计算
		if (temp.indexOf("tan^-1") >= 0) {
			temp = dt("tan^-1", temp);
		}
		// 消除sinh计算
		if (temp.indexOf("sinh") >= 0) {
			temp = dt("sinh", temp);
		}
		// 消除cos计算
		if (temp.indexOf("cosh") >= 0) {
			temp = dt("cosh", temp);
		}
		// 消除tan计算
		if (temp.indexOf("tanh") >= 0) {
			temp = dt("tanh", temp);
			}
		// 消除10的x次方
		if (temp.indexOf("e^") >= 0) {
			temp = dt("e^", temp);
		}
		// 消除10的x次方
		if (temp.indexOf("^") >= 0) {
			temp = dt("^", temp);
		}
		// 消除sin计算
		if (temp.indexOf("sin") >= 0) {
			temp = dt("sin", temp);
		}
		// 消除cos计算
		if (temp.indexOf("cos") >= 0) {
			temp = dt("cos", temp);
		}
		// 消除tan计算
		if (temp.indexOf("tan") >= 0) {
			temp = dt("tan", temp);
		}
		// 消除除法
		if (temp.indexOf("÷") >= 0) {
			temp = dt("÷", temp);
		}
		// 消除乘法
		if (temp.indexOf("×") >= 0) {
			temp = dt("×", temp);
		}
		// 消除‘/’计算
		if (temp.indexOf("/") >= 0) {
			temp = dt("/", temp);
		}
		// 消除减法
		if (temp.indexOf("-") > 0) {
			temp = dt("-", temp);
		}
		// 消除加法
		if (temp.indexOf("+") >= 0) {
			temp = dt("+", temp);
		}

		return temp;
	}

	// 一定的字符串中的加减乘除
	static String dt(String t, String temp) {
		int centerF = temp.indexOf(t);
		StringBuilder Rtemp = new StringBuilder(temp);
		try {
			switch (t) {
			case "sinh":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 3, Rtemp) + 4, transSinh(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "cosh":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 3, Rtemp) + 4, transCosh(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "tanh":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 3, Rtemp) + 4, transTanh(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "%":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + 1, transPn(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "degrees":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 6, Rtemp) + 7, transDeg(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "dms":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transDms(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "ln":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 1, Rtemp) + 2, transLn(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "e^":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 1, Rtemp) + 2, transEc(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "/":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transC1(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "tan^-1":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 5, Rtemp) + 6, transBtan(centerF,Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "cos^-1":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 5, Rtemp) + 6, transBcos(centerF,Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "sin^-1":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 5, Rtemp) + 6, transBsin(centerF,Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "yroot":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + 5 + oneR(centerF+4,Rtemp), transPf(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "!":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + 1, transN(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "√":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF, Rtemp) + 1, transSr(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "^":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transTx(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "log":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transLog(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "E":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF , Rtemp) + 1,
							transExp(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "Mod":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF + 2, Rtemp) + 3,
							transMod(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "sqr":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transSe(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case"cube":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 3, Rtemp) + 4, transCb(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "sin":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transSin(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "cos":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transCos(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "tan":
				do {
					Rtemp.replace(centerF, centerF + oneR(centerF + 2, Rtemp) + 3, transTan(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "÷":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transC1(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "×":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transC2(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "+":
				do {
					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transA2(centerF, Rtemp));
					centerF = Rtemp.indexOf(t);
				} while (centerF != -1);
				break;
			case "-":
				int c = 0;
				while (centerF != -1 && centerF != 0) {
					if (Rtemp.charAt(centerF - 1) == '+') {
						Rtemp.deleteCharAt(centerF - 1);
						centerF = Rtemp.indexOf(t);
					}

					Rtemp.replace(centerF - oneL(centerF, Rtemp), centerF + oneR(centerF, Rtemp) + 1,
							transA1(centerF, Rtemp));
					c = centerF;
					centerF = Rtemp.indexOf(t);

					if (c == centerF)
						break;
				}
				break;
			}
			return String.valueOf(Rtemp.toString());
		} catch (Exception e) {
			return "0";
		}

	}
	

	//Sinh的计算
	private static String transSinh(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 3, rtemp);
		double result = (Math.exp(n)-Math.exp(-n))/2;
		return String.valueOf(result);	
	}
	//Cosh的计算
	private static String transCosh(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 3, rtemp);
		double result = (Math.exp(n) + Math.exp(-n))/2;
		return String.valueOf(result);	
	}
	//Tanh的计算
	private static String transTanh(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 3, rtemp);
		double result = (Math.exp(n)-Math.exp(-n))/(Math.exp(n) + Math.exp(-n));
		return String.valueOf(result);	
	}
	
	private static String transPn(int centerF, StringBuilder rtemp) {
		double n1 = numL(centerF-oneL(centerF,rtemp)-1,rtemp);
		double n2 = numL(centerF, rtemp);
		double result = n1*n2*0.01;
		return String.valueOf(result);
	}

	private static String transDeg(int centerF, StringBuilder rtemp) {
		double a = numR(centerF + 6, rtemp);
		double b = (a-(int)a)*100;
		double c = (b-(int)b)*100;
		a = (int)a;
		b = (int)b;
		double result = a + b/60 + c/3600+0.00005;
		result = ((int)(result*10000))/10000.0;
		return String.valueOf(result);	
	}

	private static String transDms(int centerF, StringBuilder rtemp) {
		double a = numR(centerF + 2, rtemp);
		double b = (a-(int)a)*60;
		double c = (b -(int)b)*60;
		a = (int)a;
		b = (int)b;
		double result = a + b/100 + c/10000;
		return String.valueOf(result);
	}

	private static String transLn(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 1, rtemp);
		double result = Math.log(n);
		return String.valueOf(result);
	}
	
	private static String transEc(int centerF, StringBuilder rtemp) {
		double result = Math.pow(Math.E, numR(centerF+1, rtemp));
		return String.valueOf(result);
	}

	//tan^-1
	private static String transBtan(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 6, rtemp);
		double result = Math.atan(n)*180/Math.PI;
		return String.valueOf(result);	
	}
	//cos^-1
	private static String transBcos(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 6, rtemp);
		double result = Math.acos(n)*180/Math.PI;
		return String.valueOf(result);	
	}
	//sin^-1
	private static String transBsin(int centerF, StringBuilder rtemp) {
		double n = numR(centerF + 6, rtemp);
		double result = Math.asin(n)*180/Math.PI;
		return String.valueOf(result);		
	}

	private static String transPf(int centerF, StringBuilder rtemp) {
		double Ln = numL(centerF, rtemp);
		double Rn = numR(centerF+4,rtemp);
		double result = Math.pow(Ln, 1.0/Rn);
		return String.valueOf(result);
	}

	// 符号左边数字长度
	static int oneL(int centerF, StringBuilder temp) {
			try {
				for (int a = centerF - 1; a >= 0 && temp.charAt(a) >= '0' && temp.charAt(a) <= '9'
						|| temp.charAt(a) == '.';) {
					WebOfScience.a1.append(temp.charAt(a));
					a--;
					if (a == 0 && temp.charAt(a) == '-') {
						WebOfScience.a1.append(temp.charAt(a));
						break;
					}
					if (a < 0)
						break;
				}
				String a2 = WebOfScience.a1.toString();
				WebOfScience.a1.delete(0, WebOfScience.a1.length());

				return a2.length();
			} catch (Exception e) {
				return 0;
			}

		}

		// 获得选定的字符串
		static String getStrings(String text, int a, int b) {
			StringBuilder temp = new StringBuilder();
			for (int i = a; i <= b; i++) {
				temp.append(text.charAt(i));
			}
			return temp.toString();
		}

		// sin
		private static String transSin(int centerF, StringBuilder rtemp) {
			double n = numR(centerF + 2, rtemp);
			double result = 0;
			if(WebOfScience.rep == -1) {
				result = Math.sin(n * Math.PI / 180);
			}else if(WebOfScience.rep == 0) {
				result = Math.sin(n);
			}else if(WebOfScience.rep == 1) {
				result = Math.sin(n*Math.PI/200);
			}
			
			return String.valueOf(result);
		}

		// cos
		private static String transCos(int centerF, StringBuilder rtemp) {
			double result = 0;
			double n = numR(centerF + 2, rtemp);
			if(WebOfScience.rep == -1) {
				result = Math.cos(n * Math.PI / 180);
			}else if(WebOfScience.rep == 0) {
				result = Math.cos(n);
			}else if(WebOfScience.rep == 1) {
				result = Math.cos(n*Math.PI/200);
			}
			return String.valueOf(result);
		}

		// tan
		private static String transTan(int centerF, StringBuilder rtemp) {
			double result = 0;
			double n = numR(centerF + 2, rtemp);
			if(WebOfScience.rep == -1) {
				result = Math.tan(n * Math.PI / 180);
			}else if(WebOfScience.rep == 0) {
				result = Math.tan(n);
			}else if(WebOfScience.rep == 1) {
				result = Math.tan(n*Math.PI/200);
			}
			return String.valueOf(result);
		}

		// x^2
		private static String transSe(int centerF, StringBuilder rtemp) {
			double n = numR(centerF + 2, rtemp);
			double result = Math.pow(n, 2);
			return String.valueOf(result);
		}

		// Mod
		private static String transMod(int centerF, StringBuilder rtemp) {
			BigInteger result = BigInteger.valueOf((long) numL(centerF, rtemp))
					.mod(BigInteger.valueOf((long) numR(centerF + 2, rtemp)));
			return String.valueOf(result);
		}

		// Exp
		private static String transExp(int centerF, StringBuilder rtemp) {
			double result = numL(centerF, rtemp)*Math.pow(10, numR(centerF, rtemp));
			return String.valueOf(result);
		}

		// log(x)
		private static String transLog(int centerF, StringBuilder rtemp) {
			double n = numR(centerF + 2, rtemp);
			double result = Math.log10(n);
			return String.valueOf(result);
		}

		// ^
		private static String transTx(int centerF, StringBuilder rtemp) {
			double result = Math.pow(numL(centerF, rtemp), numR(centerF, rtemp));
			return String.valueOf(result);
		}

		// 阶乘
		private static String transN(int centerF, StringBuilder rtemp) {
			int n = (int) numL(centerF, rtemp);
			int sum = n;
			for (; n > 1; n--) {
				sum *= n - 1;
			}
			return String.valueOf(sum);
		}

		// 根号
		private static String transSr(int centerF, StringBuilder rtemp) {
			double n = numR(centerF, rtemp);
			double result = Math.sqrt(n);
			return String.valueOf(result);
		}

		//立方
		private static String transCb(int centerF, StringBuilder rtemp) {
			double n = numR(centerF + 3, rtemp);
			double result = Math.pow(n, 3);
			return String.valueOf(result);
		}

		// 除
		static String transC1(int c1, StringBuilder temp) {
			return String.valueOf((int) (numL(c1, temp) / numR(c1, temp) * 100) / 100.0);
		}

		// 乘
		static String transC2(int c2, StringBuilder temp) {
			return String.valueOf((int) (numL(c2, temp) * numR(c2, temp) * 100) / 100.0);
		}

		// 减
		static String transA1(int c1, StringBuilder temp) {
			return String.valueOf((int) ((numL(c1, temp) - numR(c1, temp)) * 100) / 100.0);
		}

		// 加
		static String transA2(int c2, StringBuilder temp) {
			return String.valueOf((int) ((numL(c2, temp) + numR(c2, temp)) * 100) / 100.0);
		}

		// 获得符号右边的数字,temp
		static double numR(int centerF, StringBuilder temp) {
			int b = centerF + 1;
			if (temp.charAt(b) == '-') {
				WebOfScience.a1.append(temp.charAt(b));
				b++;
			}
			for (; b < temp.length() && temp.charAt(b) >= '0' && temp.charAt(b) <= '9' || temp.charAt(b) == '.';) {
				WebOfScience.a1.append(temp.charAt(b));
				b++;
				if (b == temp.length())
					break;
			}
			String b2 = WebOfScience.a1.toString();
			double num = 0;
			try {
				num = Double.parseDouble(b2);
				WebOfScience.a1.delete(0, WebOfScience.a1.length());
			} catch (Exception e) {
			}
			return num;
		}

		// 获得符号左边的数字,temp
		static double numL(int centerF, StringBuilder temp) {
			try {
				for (int a = centerF - 1; a >= 0 && temp.charAt(a) >= '0' && temp.charAt(a) <= '9'
						|| temp.charAt(a) == '.';) {
					WebOfScience.a1.append(temp.charAt(a));
					a--;
					if (a == 0 && temp.charAt(a) == '-') {
						WebOfScience.a1.append(temp.charAt(a));
						break;
					}
					if (a < 0)
						break;
				}

				WebOfScience.a1.reverse();
				String a2 = WebOfScience.a1.toString();
				double num = 0;
				try {
					num = Double.parseDouble(a2);
					WebOfScience.a1.delete(0, WebOfScience.a1.length());
				} catch (Exception e) {
				}
				return num;
			} catch (Exception e) {
				return 0;
			}
		}

		// 符号右边数字长度
		static int oneR(int centerF, StringBuilder temp) {
			int b = centerF + 1;
			if (temp.charAt(b) == '-') {
				WebOfScience.a1.append(temp.charAt(b));
				b++;
			}
			for (; b < temp.length() && temp.charAt(b) >= '0' && temp.charAt(b) <= '9' || temp.charAt(b) == '.';) {
				WebOfScience.a1.append(temp.charAt(b));
				b++;
				if (b == temp.length())
					break;
			}
			String b2 = WebOfScience.a1.toString();
			WebOfScience.a1.delete(0, WebOfScience.a1.length());

			return b2.length();
		}
		
		//获得要添加前缀符号的位置
		static int getF(String text) {
			int i = text.length() - 1;
			while (text.charAt(i) >= '0' && text.charAt(i) <= '9' || text.charAt(i) == '.' || text.charAt(i) == '('
					|| text.charAt(i) == ')' || text.charAt(i) == '-') {
				if (text.charAt(i) == '-' && i == 0) {
					break;
				}
				if (text.charAt(i) == '-' && text.charAt(i - 1) == '(') {
					i = i - 2;
					break;
				} else if (text.charAt(i) == '-') {
					break;
				}
				i--;
				if (i == -1) {
					return -1;
				}
			}
			return i + 1;
		}
		
		//判断show内是否含有运算符号
		static boolean isSet(String text) {
			int i = 0;
			int len = text.length();
			int a = 0;
			while(i < len) {
				if("0123456789.".indexOf(text.charAt(i)) == -1 ) {
					a++;
				}
				i++;
			}
			if(text.charAt(0) == '-') {
				a--;
			}
			if(a == 0) {
				return false;
			}else
				return true;
		}

		//科学计数法
		static String getFe(String text) {
			double a = Double.valueOf(text);
			DecimalFormat df=new DecimalFormat("#.#####E0");
			return df.format(a);
		}
	
}
