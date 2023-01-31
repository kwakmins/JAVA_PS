## 새로 알게된 JAVA 기능,함수 목록
### 1. String 정렬이 없다.
배열 char로 바꾼 후, Arrays.sort()로 정렬 후, 다시 String으로 변경
```java
String str = "CADB"; 
char[] chars = str.toCharArray();
Arrays.sort(chars);
str = new String(chars);
  ```

### 2. String은 인스턴스가 상수로 선언되어, 추가 삭제 불가능 -> StringBuilder 사용
```java
StringBuilder sb = new StringBuilder();

sb.append("abc") // 문자열 추가 
sb.insert(2, "kk") // 2 위치에 kk 삽입 (→ abkkc)
sb.delete(0, 2) // 0~1 위치의 문자열 삭제 (→ c)
sb.deleteCharAt(2) // 2 위치의 문자 삭제 (→ ac)
sb.setCharAt(0, 'h') // 0 위치의 문자를 h로 변경 (→ hbc)
sb.reverse() // 문자열 거꾸로 뒤집기 (→ cba)
```

### 3. Char Array를 String으로 출력 -> String.valueOf(ch)
```java
String.valueOf(ch);
```

### 4. String은 래퍼 클래스라서, 연산이 안됨 -> str1.compareTo(str2)
```java
return "x">"y"; //(X)
return "X".compareTo("Y"); //얼마만큼 큰지 리턴 (큰 경우 True 작거나 같은 경우 FALSE)
-1
```

### 5. Arrays.stream(배열) 롤 stream 사용 가능 (자동으로 type mapping)

----------------------------------------------------------------------

## 자주 까먹는 JAVA 기능,함수

### 1. MAP의 3가지 종류<br>

   **HashMap**: <key, value>쌍. 특정 규칙 없이 출력됨.<br>
   **LinkedHashMap**: <key, value>쌍. 키값이 입력순으로 정렬되어 출력됨.<br>
   **TreeMap**: <key, value>쌍. 키값이 알파벳순(오름차순)으로 정렬된 상태로 출력됨.<br>


### 2. Collection 

```java
import java.utils.Collections
        
int[] arr = { 1123, 1412, 23, 44, 512132 };
List<Integer> list = new ArrayList<>(Arrays.asList(arr));

Collections.max(list) // list의 원소 중 가장 큰 값 반환
Collections.min(list) // list의 원소 중 가장 작은 값 반환

Collections.sort(list) // list 오름차순 정렬
Collections.sort(list, Collections.reverseOrder()) // list 내림차순 정렬

Collections.reverse(list) // list 역순 정렬 { 512132, 44, 23, 1412, 1123 }

Collections.frequency(list, 23) // list 내의 23의 갯수 반환

Collections.binarySearch(list, 44)
// 최초로 검색된 44의 인덱스 1 반환
// 없으면 44보다 큰 최초의 위치 2를 찾아서 -1을 곱하고 1을 빼서 반환 (-3)
```