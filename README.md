# Android


---
## **4. 사용자 인터페이스 기초**
- 사용자 인터페이스(UI : User Interface)
	- 뷰 : 사용자 인터페이스를 구성하는 기초적인 빌딩 블록
		- View 클래스를 상속받아서 작성된다.
		- **컨트롤** 또는 **위젯**이라고 불린다.
	- 뷰그룹 : 다른 뷰들을 담는 컨테이너 기능을 한다.
		- ViewGroup 클래스에서 상속받아 작성된다.
		- 흔히 **레이아웃**이라고 불린다.
	- UI를 작성하는 방법 : 뷰그룹을 먼저 생성하고 필요한 뷰들을 추가하면 된다.

- 사용자 인터페이스 작성 방법
	- XML로 작성
		- 코드와 화면 디자인을 분리할 수 있다. 코드는 프로그래머가, 화면 디자인은 디자이너가 담당할 수 있다.
		- 사용자 인터페이스가 코드의 외부에서 정의된다. 따라서 소스 코드를 변경하거나 재컴파일할 필요 없이 사용자 인터페이스를 변경할 수 있다.
		- 사용자 인터페이스는 언제든지 교체할 수 있어 빠르게 현지화할 수 있다.
		- 비주얼 도구를 이용하여서 사용자 인터페이스를 빠르게 작성할 수 있다.
		- 예제실습
		```
		
		```
	- 코드로 작성
		- 예제실습
		```

		```
		- 코드와 디자인이 분리되어 있지 않다.
		* 레이아웃 안에 다른 레이아웃을 넣을 수 있다. 즉, 컨테이너 안에 다른 컨테이너도 넣을 수 있다.

	- XML과 코드를 동시에 사용
		- 레이아웃을 처음에는 XML로 정의하고 실행 시간에 레이아웃에 포함된 뷰를 참조하여서 그 속성을 변경하는 방법
		- 예제실습

		```
        sadf
        ```

        `"@+id/button1"`
		
        - @는 리소스에서 참조한다는 의미
		- +는 새로 생성한다는 의미
		- id는 식별자를 나타내는 패키지 이름
		- button1이 식별자가 된다.

- 비주얼 도구를 이용하여 사용자 인터페이스 만들기
	- app\res\layout\main.xml 에서 design탭에서 원하는 컨트롤들을 화면에 드래그하여 배치
	- Component Tree 윈도우에는 뷰들의 계층 구조가 그려져있다.
	- Properties 창에서 속성을 변경할 수 있다.

- 뷰
	- View 클래스는 모든 뷰들의 부모 클래스이다.
	- id : 모든 뷰는 정수로 된 id를 가진다.

	    `android:id="@+id/my_button"`
	- 뷰의 위치와 크기
		- match_parent : 부모의 크기를 꽉 채운다(=fill_parent)
		- wrap_content : 뷰가 나타내는 내용물의 크기에 맞춘다.
		- 숫자 : 크기를 정확히 지정
		- 뷰의 실제 위치는 getLeft()와 getTop()으로 얻을 수 있고, 실제 너비와 높이는 getWidth()와 getHeight()로 얻을 수 있다.
	- 색상
	- 그리기
	- 마진과 패딩
		- 패딩 : 뷰와 콘텐츠와의 간격	ex) 버튼의 문자열과 버튼의 테두리와의 간격
			- paddingLeft, paddingRight, paddingTop, paddingBottom
			- setPadding(int, int, int, int) 메소드 사용
		- 마진 : 컨테이너와 뷰와의 간격
			- layout_marginLeft, layout_marginRight, layout_marginTop, layout_marginBottom
		- 예제
		```

		```

- 기초적인 뷰들
	- 텍스트 뷰

	- 에디트 텍스트

	- 이미지 뷰

	- 버튼

- LAB) 계산기 앱 작성
	- 

---
## **5. 레이아웃**
- 레이아웃
	- 레이아웃 클래스는 뷰들의 위치와 크기를 결정합니다.
	- ViewGroup 클래스로부터 상속 받는다.
	- LinearLayout
	- TableLayout
	- GridLayout
	- RelativeLayout
	- TabLayout
	- AbsoluteLayout
	- FrameLayout

- 선형 레이아웃(LinearLayout)
	- 수평 배치

	    `android:orientation="horizontal"`
	- 수직 배치

	    `android:orientation="vertical"`
	- Gravity 속성

	    `android:gravity="center"`

	- 베이스라인 정렬

        `android:baselineAligned="true"`

	- 가중치

	    `android:layout_weight="1"`

- 프레임 레이아웃(FrameLayout)
	- 여러 개의 뷰가 겹쳐져서 표시된다.
	- 프레임 레이아웃에서는 자식뷰들이 추가된 순서대로 쌓이게 된다.
	- 뷰의 가시성 제어

	    `android:visibility="visible"`

	    `android:visibility="invisible"`

- 테이블 레이아웃(TableLayout)
	- 자식 뷰들을 테이블 형태로 배치
	- 하나의 테이블은 여러 개의 TableRow 객체로 이루어지고, 하나의 TableRow 안에는 여러 개의 셀들이 들어간다.
	- 하나의 셀 안에는 하나의 뷰 객체가 들어간다.
	- 셀들의 경계선을 그리지 않는다.
	
- 상대적 레이아웃(RelativeLayout)
	- 말 그대로 상대적으로 배치됨

- 절대적 레이아웃(AbsoluteLayout)
	- 절대적인 좌표값을 주어서 뷰들을 배치하는 방법이다.
	- 사용하기 매우 쉬운 방법이지만 장치들의 화면 크기가 제각각이기 때문에 많이 사용되지는 않는다.

- 코드로 레이아웃 변경하기
	- XML로 생성하고 코드로 속성 변경하기
	- 예제실습
	```

	```
	- findViewById() 메소드는 ID에 해당하는 뷰를 찾아서 반환한다.

- 코드로 레이아웃 객체 생성하기
	- 예제실습
	```

	```
	- 사용자 인터페이스가 변경되려면 반드시 코드를 변경해야 하는 단점이 있다.
	- 따라서 특수한 경우에만 사용...

- LAB) 계산기 앱 작성


---
## **6. 입력 위젯과 이벤트 처리**
- 입력 위젯
	- 위젯 - 그래픽 사용자 인터페이스를 이루는 부품??

- 버튼
	- 텍스트 버튼
		- Button 클래스를 이용

		`android:text="@string/button_text"`

	- 이미지 버튼
		- ImageButton 클래스를 이용
		
		`android:src="@drawable/button_icon"` <- 이미지 파일 이름

	- 텍스트와 이미지를 동시에 가지는 버튼
		
		`android:text="@string/button_text"`
		`android:drawableLeft="@drawable/button_icon"`

	- 버튼의 이벤트 처리
		- 클릭 이벤트가 발생하면 레이아웃에 등록된 메소드가 자동으로 호출된다.
		- onClick 속성을 추가

		`android:onClick="onClick"`	<- 이벤트를 처리하는 메소드 이름
		
		`public void onClick(View view){ ··· }` <- XML 파일에 적었던 메소드를 구현

	- 예제 : 이미지 버튼 만들기
	```

	```

	- 예제 : 커스텀 버튼
	```

	```
	
- 이벤트를 처리하는 방법
	- XML 파일에 이벤트 처리 메소드를 등록하는 방법
		- 클릭 이벤트만을 처리할 수 있는 방법
		- 버튼과 같은 위젯의 경우, 가장 간단하게 이벤트를 처리할 수 있다.
	- 이벤트를 처리하는 객체를 생성하여 이벤트를 처리하는 방법
		- 이벤트를 처리하는 객체를 별도로 생성하여 위젯에 등록
		- 이벤트를 처리하는 가장 일반적인 방법
	- 뷰 클래스의 이벤트 처리 메소드를 재정의하는 방법
		- 커스텀 뷰를 작성하는 경우에만 사용할 수 있는 방법

- 이벤트 처리 객체를 이용하여 이벤트 처리하기
	- 이벤트를 처리하는 메소드들이 정의된 인터페이스를 **이벤트 리스너**라고 부른다.
	```
	class MyClass{
		// 리스너 인터페이스를 구현한 클래스 정의
		class Listener implements OnClickListener{
			public void onClick(View v){
				...
			}
		}

		Listener lis = new Listener();	// 이벤트 리스너 객체 생성
		button.setOnClickListener(lis);	// 버튼에 이벤트 리스너 객체를 등록
	}
	```
	- 무명 클래스를 사용하여서 이벤트를 처리하는 방법
	```
	Button button = (Button) findViewById(R.id.button_send);
	button.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// 버튼이 클릭되면 여기서 어떤 작업을 한다.
		}
	});
	```

	- 리스너 객체를 생성하는 방법
		- 리스너 클래스를 **내부 클래스**로 정의한다.
		- 리스너 클래스를 **무명 클래스**로 정의한다.
		- 리스너 인터페이스를 **액티비티 클래스**에 구현한다.

	- 내부 클래스로 처리하는 방법
		- 내부 클래스는 자신이 속해있는 클래스의 멤버들에 자유롭게 접근하여 사용할 수 있다는 큰 장점이 있다.

	```
	- Toast 기능
	Toast는 뷰의 일종으로 화면에 잠깐 나타나는 메시지를 표시할 때 사용된다.
	사용자에게 방해가 되지 않으면서 어떤 정보를 표시할 목적으로 작성되었다.
	일반적으로 정적 메소드인 makeText()를 호출하여 토스트 객체를 생성하고
	show() 메소드를 호출하여서 메시지를 표시한다.
	```
	
	- 무명 클래스로 처리하는 방법

	- 액티비티에 인터페이스를 구현하는 방법

- 텍스트 필드
	- 텍스트 필드를 사용하면 사용자가 앱에 텍스트를 타이핑하여 입력할 수 있다.

- 체크 박스
	- 체크 박스는 사용자가 하나의 그룹 안에서 여러 개를 동시에 선택할 때 사용하는 위젯이다.
	```

	```

- 라디오 버튼
	- 라디오 버튼은 하나의 그룹 안에서는 한 개의 버튼만 선택할 수 있다.
	```

	```

- 토글 버튼
	- 두 가지의 상태 중의 하나로 토글되도록 만들어진 버튼
	```

	```
	