import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	String time;
	int temp;
public Time(){
		time=new SimpleDateFormat("yyyy MM dd HH mm ss").format(Calendar.getInstance().getTime());
}
public int getYear() {
	temp+=time.charAt(0)-48;
	temp*=10;
	temp+=time.charAt(1)-48;
	temp*=10;
	temp+=time.charAt(2)-48;
	temp*=10;
	temp+=time.charAt(3)-48;
	return temp;
}
public int getMonth() {
	temp+=time.charAt(5)-48;
	temp*=10;
	temp+=time.charAt(6)-48;
	return temp;
}
public int getDay() {
	temp+=time.charAt(8)-48;
	temp*=10;
	temp+=time.charAt(9)-48;
	return temp;
}
public int getHour() {
	temp+=time.charAt(11)-48;
	temp*=10;
	temp+=time.charAt(12)-48;
	return temp;
}
public int getMinute() {
	temp+=time.charAt(11)-48;
	temp*=10;
	temp+=time.charAt(12)-48;
	return temp;
}
public int getSecond() {
	temp+=time.charAt(11)-48;
	temp*=10;
	temp+=time.charAt(12)-48;
	return temp;
}
}
