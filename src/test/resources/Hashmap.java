import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashmap {
	public static void main(String[] args) {
		Map<String, String> org = new HashMap<String, String>();
		org.put("id", "A");
		org.put("name", "北京分公司");
		List<Map<String, String>> cd = new ArrayList<>();
		cd.add(org);
		System.out.println("wanjie");
	}
}
