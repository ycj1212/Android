# **Android**


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
	
- 레이팅 바
	- 레이팅 바는 별 모양을 이용하여서 점수를 주는 경우에 사용되는 위젯
	```

	```
	
- 커스텀 컴포넌트
	- 개발자가 직접 View 클래스를 상속받아서 필요한 위젯을 개발할 수 있다.
	```

	```



---
## **5. 메뉴와 대화상자**
- 사용자 인터페이스 개요
	- 네비게이션 바
	- 액션바
	- 다중 패널 레이아웃
	- 앱의 외관 커스텀화
	- 터치 피드백
	- 제스처
		- 터치
		- 오래 누르기
		- 드래그, 스와이프
		- 더블터치
		- 오래 누르면서 드래그
		- 더블 터치 드래그
		- 핀치 열기, 닫기

- 메뉴
	- 옵션 메뉴 : MENU 버튼을 누르면 나타는 메뉴
	- 컨텍스트 메뉴 : 요소를 길게 누르면 나타는 메뉴
	- 팝업 메뉴 : 특정한 뷰에 붙어서 나타나는 수직방향의 리스트
	
- XML로 메뉴 정의하기
	- 메뉴 구조를 쉽게 시각화할 수 있다.
	- 코드와 메뉴가 분리되어서 차후에 쉽게 변경할 수 있다.
	- 플랫폼 버전이나 화면 크기에 따라서 서로 다른 메뉴 구성을 가질 수 있다.
	```

	```

- 옵션 메뉴 생성하기
	- 옵션 메뉴는 현재 액티비티와 관련된 여러 가지 동작이나 선택사항을 설정하는 메뉴이다.
	```
	@Override
	// 액티비티의 메소드 onCreateOptionMenu()를 재정의한다.
	public boolean onCreateOptionMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mymenu, menu);		// 메뉴 리소스 팽창
		return true;
	}
	```
	- 메뉴 팽창(inflate)
		- 메뉴 리소스를 팽창하면 실제 메뉴가 생성된다.
		- 팽창한다는 의미는 프로그래밍 객체로 변환한다는 뜻이다.

	- 클릭 이벤트 처리
	```

	```

	- 코드로 옵션 메뉴 생성하기

- 컨텍스트 메뉴
	- 플로팅 컨텍스트 메뉴 : 항목 위에 오래누르기를 하면 메뉴가 표시됨
	- 컨텍스트 액션 메뉴 : 선택된 항목에 관련된 메뉴가 액션바에 표시됨

- 팝업 메뉴
	- 특정한 뷰에 붙어있는 메뉴

- 대화 상자
	- 사용자에게 메시지를 출력하고 사용자로부터 입력을 받아들이는 사용자 인터페이스
	- AlertDialog

- DatePickerDialog


- 커스텀 대화 상자

- 알림기능
	- 알림을 만드는 절차
		1. 알림 빌더를 생성한다.
		```
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		```
		2. 알림 속성을 설정한다.
		```
		builder.setSmallIcon(R.drawable.notification_icon);
		builder.setContentTitle("알려드립니다.");
		builder.setContentText("이것은 시험적인 알림입니다.");
		```
		3. 액션을 첨부한다.
		```
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);
		```
		4. 알림 생성
		```
		NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(NOTIFICATION_ID, builder.build());
		```


---
## **6. 그래픽**
- 그래픽
	- 2차원 그래픽을 사용하는 방법
		1. 캔버스에 코드로 직접 그린다. onDraw() 메소드 안에 draw...()와 같은 메소드 호출
			- UI 액티비티와 같은 스레드 안에서 커스텀 뷰를 생성하고 invalidate()를 호출하여 화면을 그린다. invalidate()는 onDraw()를 호출한다.
			- 별도의 화면과 스레드를 생성하여서, UI 스레드와는 독립적으로 그래픽을 그린다.
		2. 레이아웃 파일 안에서 그래픽이나 애니메이션을 정의

- 커스텀 뷰를 사용하여 그리기
	```
	class MyView extends View {
		...
		protected void onDraw(Canvas canvas) {
			Paint paint = new Paint();
			// 여기에 그림을 그리는 코드 작성
		}
	}

	public class MainActivity extends AppCompatActivity {
		public void onCreate(Bundle is) {
			...
			MyView w = new MyView(this);
			setContentView(w);
			// MyView를 생성하고 이것을 Activity의 컨텐트 뷰로 설정
		}
	}
	```

	- Canvas 클래스
		- 그림을 그리는 캔버스에 해당되는 것으로 Bitmap 객체를 가지고 있다.
		- onDraw()에서는 캔버스가 주어지지만 우리가 새로운 캔버스를 생성할 수도 있는데 이 때는 비트맵도 함께 생성하여야 한다.
		```
		Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		```

	* 그림이 그려지는 화포가 Canvas, 붓이나 물감이 Paint

	- Paint 클래스
		- Canvas의 메소드는 항상 Paint 객체를 마지막 매개변수로 하여 호출되어야 한다.

	- 커스텀 뷰를 XML 파일에서 참조하는 방법
	```
	
	```

- 그리기 속성
	- 색상
		- 색상은 색의 3원색인 Red, Green, Blue 성분을 8비트로 표시하여 나타낸다.
		- 따라서 24비트이면 하나의 색상을 표현할 수 있고, 24비트를 16진수로 표시하는 것이 일반적

		`paint.setColor(0xFF0000); // Red`

		`paint.setColor(Color.RED);`

	- 앤티 에일리어싱 : 도형의 경계부분을 더 매끄럽게 그려지도록 하는 기술

	- 폰트 변경
		- Typeface 클래스의 객체로 표현
		- 폰트 생성 Typeface.create()
		- 폰트 변경 setTypeface()
		- 설정된 폰트를 이용하여 화면에 그리려면 Paint 클래스의 drawText()
	```

	```

- 패스 그리기
	- 패스는 복잡한 기하학적인 경로를 표시한다.

- 이미지 표시하기
	- ImageView를 사용하는 방법
	
	- 이미지를 직접 그려주는 방법
	```
	Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
	( 이미지 데이터를 포함하는 애플리케이션 리소스 객체, 이미지의 리소스 식별자 )
	```
	- decodeResource()는 첫 번째 인수인 리소스 객체에서 두 번째 인수인 식별자에 해당하는 리소스를 찾고 디코딩하여 비트맵으로 변환한다.

	
	```
	void drawBitmap(Bitmap bitmap, float left, float top, Paint paint);
	(화면에 그릴 비트맵, 이미지가 그려지는 위치, 변환 행렬이 들어 있는 Paint 객체)
	* 여기서 이미지를 변환할 필요가 없다면 paint는 null로 주어도 된다.
	```

	- 비트맵의 확대 및 축소
	```
	Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
	Bitmap sb = Bitmap.createScaledBitmap(b, 60, 80, false);
	60*80 크기의 새로운 비트맵 생성
	```
	
	- 비트맵의 변환
		- 상하가 뒤집힌 비트맵 생성
		```
		Matrix m = new Matrix();	// 변환 행렬을 생성
		m.preScale(1, -1);	// x값에 1을 곱하고 y값에 -1을 곱하는 변환행렬을 만든다.		
		Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
		Bitmap mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, false);
		// 변환 행렬 m이 적용된 새로운 비트맵을 생성한다.
		```

- 도형 객체 이용하기
	- android.graphics.drawable 패키지에는 2차원 도형을 정의하는 클래스들이 포함되어 있다.
	- 버튼의 이미지를 제작하거나 배경 이미지를 만들 때 사용하면 편리하다.

	- XML로 도형 정의하기
	```
	<?xml version="1.0" encoding="utf-8"?>
	<shape
		xmlns:android="http://schemas.android.com/apk/res/android"
		android:shape=["rectangle" | "oval" | "line" | "ring"] >
		
		...

	</shape>
	```

- Transition API 애니메이션
	- 버튼과 텍스트에 간단한 애니메이션 효과를 주는 용도로 많이 사용


- 드로워블 애니메이션
	- 영화 필름처럼 여러 개의 이미지가 순서대로 재생되어서 생성되는 전통적인 애니메이션이다.
	- AnimationDrawable 클래스가 프레임 애니메이션의 기초 클래스

- 서피스 뷰
	- 그리기 전용의 화면을 제공하는 뷰
	```
	class MyView extends SurfaceView implements SurfaceHolder.Callback{
		public void surfaceCreated(SurfaceHolder holder){
			// 서피스가 준비되었으므로 스레드를 시작한다.
		}

		public void surfaceDestroyed(SurfaceHolder holder){
			// 서피스가 소멸되었으므로 스레드를 종류한다.
		}

		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
			// 서피스가 변경
		}
	}

	class MyThread extends Thread {
		SurfaceHolder holder;
		...
		public void run(){
			canvas = holder.lockCanvas();
			// 캔버스에 그림을 그린다.
			...
			...
			holder.unlockCanvasAndPost(canvas);
		}
	}
	```

---
## **7. 고급 위젯과 프래그먼트**

1. 어댑터 뷰(AdapterView) 클래스
	- 화면에서 동적으로 변경되는 콘텐츠를 채울 때 사용
	- 배열, 파일, 데이터베이스에서 저장된 데이터를 읽어서 화면에 표시할 때 유용한 뷰
		- 리스트 뷰(ListView)
		- 갤러리(Gallery)
		- 그리드 뷰(GridView)

	- 어댑터 뷰에 데이터를 공급하는 클래스가 **어댑터(Adapter)** 이다.
	- 어댑터는 데이터 소스와 어댑터 뷰 중간에 위치하여서 데이터 소스에서 데이터를 읽어서 어댑터 뷰에 공급한다.
		- ArrayAdapter : 배열에서 데이터를 가져옴
		- SimpleCursorAdapter : 데이터베이스에서 데이터를 가져옴
	
		`데이터 -> Adapter -> AdapterView`
	
2. 리스트 뷰(ListView)
	- 리스트 뷰는 항목들을 수직으로 보여주는 어댑터 뷰로 상하로 스크롤이 가능
	- 스마트폰에서 사용하기 쉽기 때문에 아주 많이 사용
	- ListActivity 클래스 사용

	`ArrayAdapter(Context context, int textViewResourceId, T[] object)`

	`현재 애플리케이션 컨텍스트, 레이아웃 아이디, 배열`

	- 두 번째 매개변수인 레이아웃 아이디는 사용자가 직접 지정할 수도 있지만, 통상적으로 안드로이드가 제공하는 표준적인 레이아웃을 사용할 수도 있다.
	
	```
	R.layout 클래스 파일 안에 정의되어있다.
	- simple_list_item_1			:	한 개의 텍스트 뷰 사용
	- simple_list_item_2			:	두 개의 텍스트 뷰 사용
	- simple_list_item_checked		:	항목당 체크 표시
	- simple_list_item_single_choice	:	한 개의 항목만 선택
	- simple_list_item_mutiple_choice	:	여러 개의 항목 선택 가능
	```
	
	- ListActivity 클래스는 ListView를 화면으로 사용하는 액티비티이다.
	- setListAdapter()를 호출하여서 리스트뷰와 어댑터를 연결
	- onListItemClick()은 리스트의 항목이 클릭되면 호출
	
	```
	ArrayAdaptor 클래스는 제네릭 클래스로 정의되어 있다.
	제네릭 클래스란 타입 매개변수를 사용하여서 클래스 안에서 사용되는 데이터 타입을 마음대로 변경할 수 있는 클래스이다.
	제네릭 클래스에서 타입 매개변수는 객체 생성 시에 프로그래머에 의해 결정된다.
	<...> 를 사용하여서 사용하고 싶은 타입을 지정하면 된다.
	
	new ArrayAdapter<String>(...)

	ArrayAdapter 클래스
	T 타입 참조 변수
	T = Integer		->	Integer 객체 '10'
	T = String		->	String 객체 "Hello World!"
	```

3. 그리드 뷰(GridView)
	- 2차원 그리드에 항목들을 표시하는 뷰그룹이다.

4. 스피너(Spinner)
	- 항목을 선택하기 위한 드롭 다운 리스트와 유사하다.
	- 기본적인 상태에서는 현재 선택된 값을 보여준다.

5. 프로그레스 바(ProgressBar)
	- 작업의 진행 정도를 표시하는 위젯이다.

	- 시크 바(SeekBar)
		- 프로그레스 바의 확장판이다. 사용자가 드래그할 수 있는 썸(thumb)이 추가

6. 레이팅 바(RatingBar)
	- 시크 바와 프로그레스 바의 확장판이다.
	- 별을 사용하여 점수를 표시한다.
	- ratingBarStyleSmall : 작은 크기
	- ratingBarStyleIndicator : 표시만 되고 사용자 상호작용 지원XX
	- 사용자 상호작용 지원하는 레이팅 바를 사용할 때는 왼쪽이나 오른쪽에 위젯을 두지 말아야 한다.
	- 별들의 개수는 setNumStars(int) 나 XML레이아웃(너비가 wrap_content)으로 설정


7. 프래그먼트(Fragment)
	- 액티비티의 사용자 인터페이스를 여러 개의 조각으로 나눌 수 있고, 이 조각을 프래그먼트라고 한다.
	- 서브 액티비티(sub-activity)

8. 다중 창 지원
	- Android N에서는 둘 이상의 앱을 동시에 표시할 수 있다.
	- PIP 모드

---
## **8. 액티비티와 인텐트**

1. 애플리케이션, 액티비티, 액티비티 스택, 태스크
	- 안드로이드와 같은 모바일 플랫폼은 일반적인 컴퓨터의 실행 환경과는 약간 차이가 있다.
	- 일반적인 컴퓨터에서는 애플리케이션 단위로 실행되지만, 안드로이드에서는 액티비티 단위로 실행된다.
	
	- 애플리케이션
		- 애플리케이션은 여러 개의 액티비티들로 구성된다.
		- 안드로이드 안에는 많은 애플리케이션들이 내장되어 있다.
	
	- 액티비티
		- 사용자가 어떤 작업(전화를 거는 작업, 사진을 찍는 작업, ...)을 할 수 있는 화면을 가지고 있는 애플리케이션 구성 요소이다.
		- 각 액티비티는 사용자 인터페이스가 그려지는 윈도우를 가지고 있다.
		- 안드로이드에서 실행 단위는 액티비티이다.
		- 하나의 액티비티에서 다른 액티비티를 시작하려면 startActivity()를 호출한다.
		- 다른 애플리케이션의 액티비티도 실행 가능
		- 안드로이드는 두 개의 액티비티를 같은 태스크 안에서 유지한다.
		- 태스크는 어떤 작업을 수행하기 위하여 사용자가 상호작용하는 액티비티들의 그룹이다.
	
	- 태스크와 백 스택
		- 사용자가 BACK 버튼을 터치하면 현재 액티비티가 종료되고 이전 액티비티로 되돌아간다.
		- 따라서 사용자가 방문한 액티비티들은 어딘가에 기억되어 있어야 한다.
		- 이런 용도로 사용되는 것이 백 스택 또는 액티비티 스택이라고도 한다.
		- 장치의 홈 화면은 대부분의 태스크가 시작되는 곳이다.
		- 사용자가 아이콘을 터치하면 애플리케이션의 태스크를 찾는다.
		- 만약 최근에 실행되지 않아서 애플리케이션을 위한 태스크가 없다면 새로운 태스크가 생성되고 애플리케이션의 메인 액티비티가 스택의 바닥에 추가된다(이것을 루트 액티비티라고 한다).

			| 액티비티3 | ← 현재 실행되는 액티비티
			| 액티비티2 |
			| 액티비티1 |
			------------
			액티비티 스택

		- 현재 액티비티가 다른 액티비티를 시작하면 이 액티비티가 스택의 맨 위에 삽입된다(push).
		- 스택의 맨 위에 있는 액티비티는 현재 실행되고 있는 액티비티이다.
		- 사용자가 BACK 키를 누르면 현재 액티비티는 스택에서 제거된다(pop).
		- 스택에 있는 액티비티들은 절대로 위치가 변경되지 않기 때문에 스택에 동일한 액티비티가 이미 존재하더라도 다시 스택의 윗부분에 추가될 수 있다.

			| 액티비티3 |
			| 액티비티1 |
			| 액티비티2 |
			| 액티비티1 |
			------------

2. 인텐트
	- 하나의 액티비티에서 다른 액티비티를 시작하려면 액티비티의 실행에 필요한 여러 가지 정보들을 보내주어야 한다. 이때 사용하는 메시지가 인텐트이다.
	- 액티비티와 같은 컴포넌트들은 인텐트라고 불리는 메시지를 통해서 활성화된다.
	
	- 명시적 인텐트(explicit intent)
		- 명시적 인텐트에서 타깃 컴포넌트의 이름을 지정한다.
		- 즉, "애플리케이션 A의 컴포넌트 B를 구동시켜라"와 같이 명확하게 지정하는 것이다.
		- 동일한 애플리케이션 내에 있는 다른 액티비티를 실행하는 데 사용된다.

	- 암시적 인텐트(implicit intent)
		- 암시적 인텐트에서는 타깃 컴포넌트의 이름을 지정하지 않는다.
		- 예를 들면, "지도를 보여줄 수 있는 컴포넌트이면 어떤 것이라도 좋다"와 같다.
		- 다른 애플리케이션의 컴포넌트를 구동하는데 사용된다.
	
3. 명시적 인텐트

4. 여러 페이지로 구성된 애플리케이션 작성

5. 액티비티로부터 결과받기

6. 암시적 인텐트

7. 멀티태스킹

8. 태스크 관리하기

9. 인텐트 필터

10. 액티비티 생애주기

11. 액티비티 상태 저장


---
## **9. 리소스와 보안**

1. 리소스
