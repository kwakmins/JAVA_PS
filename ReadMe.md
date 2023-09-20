## 새로 알게된 JAVA 기능,함수 목록

### 1. String 정렬이 없다.

1.1 `.toCharArray()`를 통해 `char[]`로 바꾼 후, `Arrays.sort()`로 정렬 후, 다시 String으로 변경

```java
String ystr = "CADB";
char[]chars = str.toCharArray();
Arrays.sort(chars);
str=new String(chars);
```

1.2 `Split("")`을 통해 `String[]`을 통해 `Arrays.sort()`로 정렬 (reverse 사용 가능), `join`으로 다시 합치기

```java
String str = "CADB";
String[] s = str.split("");
Array.sort(s,Collection.reverseOrder());
str = String.join("",s);

// str.split("",-1)을 하면, 빈 문자열도 생성됨
```

### 2. String은 인스턴스가 상수로 선언되어, 추가 삭제 불가능 -> `StringBuilder` 사용

```java
StringBuilder sb = new StringBuilder();

sb.append("abc"); // 문자열 추가 
sb.insert(2,"kk"); // 2 위치에 kk 삽입 (→ abkkc)
sb.delete(0,2); // 0~1 위치의 문자열 삭제 (→ c)
sb.substring(0,2) // 0~1 위치의 문자열 자르기 (-> ab) (String으로 바뀜)
sb.deleteCharAt(2); // 2 위치의 문자 삭제 (→ ac)
sb.replace(0,2,"bc"); // 0~1의 문자열을 다른 문자열로 변경(-> bcc)
sb.setCharAt(0,'h'); // 0 위치의 문자를 h로 변경 (→ hbc)
sb.reverse(); // 문자열 거꾸로 뒤집기 (→ cba)
```

### 4. String은 래퍼 클래스라서, 연산이 안됨 -> `str1.compareTo(str2)`

```java
// return"x">"y"; //(X)
return "X".compareTo("Y"); //얼마만큼 큰지 리턴 (큰 경우 True 작거나 같은 경우 FALSE)
    // -1
```

### 5. `Arrays.stream(배열)` 롤 stream 사용 가능 (자동으로 type mapping)
```java
String[] strs = {"asdf", "zxcv"};
List<String> collect = Arrays.stream(strs)
    .map(String::new)
    .collect(Collectors.toList());
```

## 6. String과 int의 배열 <-> List 변환
```java
List<Integer> intList = Arrays.stream(intArr).boxed().toList();
List<String> stringList = Arrays.asList(stringArr);

int[] ints = intList.stream().mapToInt(i -> i).toArray();
String[] strings = stringList.toArray(new String[0]); // 0으로 하면 저절로 숫자에 맞게 증가
string[] strings = stringList.stream().toArray(String[]::new)
```
----------------------------------------------------------------------

## 자주 까먹는 JAVA 기능,함수

### 1. MAP의 3가지 종류<br>

**HashMap**: <key, value>쌍. 특정 규칙 없이 출력됨.<br>
**LinkedHashMap**: <key, value>쌍. 키값이 입력순으로 정렬되어 출력됨.<br>
**TreeMap**: <key, value>쌍. 키값이 알파벳순(오름차순)으로 정렬된 상태로 출력됨.<br>

### 2. Collection

```java
import java.utils.Collections;
        
int[]arr={1123,1412,23,44,512132};
List<Integer> list=new ArrayList<>(Arrays.asList(arr));

Collections.max(list) // list의 원소 중 가장 큰 값 반환
Collections.min(list) // list의 원소 중 가장 작은 값 반환
Collections.sort(list) // list 오름차순 정렬
Collections.sort(list,Collections.reverseOrder()) // list 내림차순 정렬
Collections.reverse(list) // list 역순 정렬 { 512132, 44, 23, 1412, 1123 }
Collections.frequency(list,23) // list 내의 23의 갯수 반환
Collections.binarySearch(list,44)
// 최초로 검색된 44의 인덱스 1 반환
// 없으면 44보다 큰 최초의 위치 2를 찾아서 -1을 곱하고 1을 빼서 반환 (-3)
```
---
## Skill
### 1. 배열 복사
```java
System.arraycopy(origin, 0, key, 0, origin.length); // orgin의 0의 위치부터 origin.length길이 까지 key에 0의 위치부터 복사함 
Arrays.copyOf(arr,len); // arr의 len만큼 복사 (길이 지정됨)
```
### 2. Integer.toString(10,2) // "1010" <br> Integer.parseInt("1010",2) // 10