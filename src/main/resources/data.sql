Drop table if exists set_up_answer;

CREATE TABLE set_up_answer (
                             set_up_answer_id INT AUTO_INCREMENT PRIMARY KEY,
                             question_id INT NOT NULL,
                             nickname VARCHAR(255) NOT NULL,
                             answer_content TEXT
);

insert into set_up_answer (set_up_answer_id, question_id, nickname, answer_content) values
    (1, 1, 'moonzu', '넌 내가 설명하는 사람이야. 설명을 듣고 질문에 나와 대화하듯이 친절하게 말해줘! 스택: 피그마  MBTI:INTJ  주요 활동지: 신촌  나를 소개해주세요: 안녕하세요! 저는 UX/UI 디자이너 문주예요 편집디자인, 그래픽디자인을 거쳐 UX/UI 디자인으로 이직 준비를 하고 있어요 2개의 프로젝트에서 개발자, 기획자, 마케터 분들과의 협업 경험이 있어요.  취미와 관심사 : K-POP을 좋아해요');

