package acorntbl;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class AcornService {

    // AcornDAO 클래스의 인스턴스를 생성하여 사용하기 위해 dao 멤버 변수를 선언합니다.
    AcornDAO dao = new AcornDAO();

    // Acorn 리스트를 JSON 배열 형태로 반환하는 메서드입니다.
    public JSONArray getAcornList() {

        // AcornDAO 클래스를 통해 Acorn 객체 리스트를 가져옵니다.
        ArrayList<Acorn> list = dao.getAcornList();
        
        // 결과를 저장할 JSON 배열을 생성합니다.
        JSONArray arr0 = new JSONArray();
        
        // Acorn 객체 리스트를 순회하면서 JSON 객체로 변환하여 JSON 배열에 추가합니다.
        for (int i = 0; i < list.size(); i++) {
            Acorn a = list.get(i);
            
            // 각각의 Acorn 객체를 JSON 객체로 변환합니다.
            JSONObject o = new JSONObject();
            o.put("id", a.getId());     // id 속성에 Acorn 객체의 id 값을 추가합니다.
            o.put("pw", a.getPw());     // pw 속성에 Acorn 객체의 pw 값을 추가합니다.
            o.put("name", a.getName()); // name 속성에 Acorn 객체의 name 값을 추가합니다.
            
            // JSON 객체를 JSON 배열에 추가합니다.
            arr0.put(o);
        }
        
        // 최종적으로 JSON 배열을 반환합니다.
        return arr0;
    }
}
