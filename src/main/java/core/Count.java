package core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {

		private static int count;
		public static void main(String[] args) throws IOException {
			List<String> al=new ArrayList<String>();
			
			BufferedReader pipe=new BufferedReader(new InputStreamReader(System.in));
			String in=pipe.readLine();
			
//			String in="Nikita Christina Svetlana Alex Christina Svetlana Christina Svetlana Alex Christina Christina";
			String[]a=in.split(" ");
//			String[]a=in.split(System.getProperty("line.separator"));
			for(String s:a){
				count=0;
				for(int i=0;i<a.length;i++){
					Pattern p=Pattern.compile(a[i]);
					Matcher m=p.matcher(s);
					while (m.find())
						count++;}
//				al.add(s+"\t\t:"+count);
				al.add(count+": "+s);}
			
			Set<String> hs=new TreeSet<String>(al);
//			Reverse order
			hs=((TreeSet<String>)hs).descendingSet();
//			for (String als:al) {System.out.println(als);}
			for (String hss:hs) {System.out.println(hss);}
				}
			
		}
	

