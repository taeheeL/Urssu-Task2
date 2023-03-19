# Urssu-Task2

## 코드 설명
1. 본 과제는 **MVVM 패턴**으로 작성했습니다.
2. 사용자가 입력한 이메일은 **LiveData**로, 비밀번호는 **Flow**로 관리합니다.
3. **양방향 데이터 바인딩**을 활용해 Activity에서 별도의 binding 작업 없이 xml에서 바로 binding 합니다. 
4. 입력한 이메일과 비밀번호는 **SharedPreference**를 활용해 SignUpResultActivity로 값을 전달하고 할당합니다.
5. 입력한 비밀번호는 정규식으로 유효성 검증하기 전 **300ms 디바운스 단계**를 거칩니다. 
6. 유효성 검증 단계는 "empty", "valid", "invalid" 3단계로 나뉘며 각 상태에 따라 **BindingAdapter**에서 결과를 View에 할당합니다. 

## 시연 영상
https://user-images.githubusercontent.com/98825364/226162312-261622c2-3c69-49ad-bd48-557386d07481.mp4

