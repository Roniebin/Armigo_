from selenium import webdriver
from bs4 import BeautifulSoup
import requests
import os
import time
from urllib.parse import urljoin

# 웹드라이버 설정

'''
# 숲속드레스 !!
urls = [
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=1",
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=2",
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=3"
]

# 릴리드레스 !!
urls = [
    "https://lilydress.co.kr/product/list.html?cate_no=428"
]

# 모반디 !!
urls = [
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=1",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=2",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=3",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=4",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=5"
]

# 메리슈가 !!
urls = [
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=2",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=3",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=4",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=5",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=6",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=7",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=8"
]

# 베일즈 !!
urls = [
    "https://veils.co.kr/product/list.html?cate_no=85",
    "https://veils.co.kr/product/list.html?cate_no=85&page=2",
    "https://veils.co.kr/product/list.html?cate_no=85&page=3",
    "https://veils.co.kr/product/list.html?cate_no=85&page=4",
    "https://veils.co.kr/product/list.html?cate_no=85&page=5",
]

# 와이지 드레스 !!
urls = [
    "https://ygdress.com/product/list.html?cate_no=62&page=1",
    "https://ygdress.com/product/list.html?cate_no=62&page=2"
]

# 루나스 드레스 !!
urls = [
    "https://lunasdresshouse.com/category/%EC%85%80%ED%94%84%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/48/?page=1",
    "https://lunasdresshouse.com/category/%EC%85%80%ED%94%84%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/48/?page=2"
]

# 로엘 드레스 !!
urls = [
    "https://roeldress.com/product/list.html?cate_no=27",
    "https://roeldress.com/product/list.html?cate_no=27&page=2",
    "https://roeldress.com/product/list.html?cate_no=27&page=3",
    "https://roeldress.com/product/list.html?cate_no=27&page=4",
    "https://roeldress.com/product/list.html?cate_no=27&page=5"
]

# LUlus : 첫 1장 마지막 1장 스킵 필요
urls = [ 
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?c=98",
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?p=2&c=98",
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?p=3&c=98"
]

# DRESSY ONLINE : 초반 4장 삭제 요구
urls = [ 
    "https://weddingdress.pla-cole.wedding/c/weddingdress/"
]
'''

# 링크모음
urls = [
    "https://weddingdress.pla-cole.wedding/c/weddingdress/",
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?c=98",
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?p=2&c=98",
    "https://www.lulus.com/categories/2042_3502/wedding-dresses.html?p=3&c=98",
    "https://roeldress.com/product/list.html?cate_no=27",
    "https://roeldress.com/product/list.html?cate_no=27&page=2",
    "https://roeldress.com/product/list.html?cate_no=27&page=3",
    "https://roeldress.com/product/list.html?cate_no=27&page=4",
    "https://roeldress.com/product/list.html?cate_no=27&page=5",
    "https://lunasdresshouse.com/category/%EC%85%80%ED%94%84%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/48/?page=1",
    "https://lunasdresshouse.com/category/%EC%85%80%ED%94%84%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/48/?page=2",
    "https://ygdress.com/product/list.html?cate_no=62&page=1",
    "https://ygdress.com/product/list.html?cate_no=62&page=2",
    "https://veils.co.kr/product/list.html?cate_no=85",
    "https://veils.co.kr/product/list.html?cate_no=85&page=2",
    "https://veils.co.kr/product/list.html?cate_no=85&page=3",
    "https://veils.co.kr/product/list.html?cate_no=85&page=4",
    "https://veils.co.kr/product/list.html?cate_no=85&page=5",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=2",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=3",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=4",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=5",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=6",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=7",
    "https://marry-sugar.co.kr/category/%EC%9B%A8%EB%94%A9%EB%93%9C%EB%A0%88%EC%8A%A4/184/?page=8",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=1",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=2",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=3",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=4",
    "https://mobandi.co.kr/product/list.html?cate_no=99&page=5",
    "https://lilydress.co.kr/product/list.html?cate_no=428",
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=1",
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=2",
    "https://supsokdress.com/category/%EB%A1%B1%EB%93%9C%EB%A0%88%EC%8A%A4/4/?page=3"
]

# 이미지 저장할 폴더 설정
os.makedirs('images', exist_ok=True)

headers = {'User-Agent': 'Mozilla/5.0'}
dress_counter = 1

# 각 페이지를 순회하며 이미지 다운로드
for url in urls:
    driver = webdriver.Chrome()  # 크롬 드라이버 사용
    driver.get(url)

    # 페이지가 로드될 시간을 기다림
    time.sleep(5)

    # 페이지 소스 가져오기
    soup = BeautifulSoup(driver.page_source, 'html.parser')

    # 이미지 태그 찾기
    img_tags = soup.find_all('img')

    for img_tag in img_tags:
        img_url = img_tag.get('src') or img_tag.get('data-src')
        
        if img_url:
            img_url = urljoin("https://supsokdress.com", img_url)  # 절대 URL로 변환

            try:
                response = requests.get(img_url, headers=headers)
                response.raise_for_status()  # HTTP 에러가 있는지 확인
                if 'image' in response.headers.get('Content-Type', '') and not img_url.endswith('.gif'):
                    # 파일 이름이 25자 이상인 경우에만 저장 (드레스 이미지 필터링)
                    if len(img_url.split('/')[-1]) >= 25:
                        img_data = response.content
                        img_name = os.path.join('images', f'dress_{dress_counter}.jpg')
                                            # 이미지 파일 유효성 검사 후 저장
                        try:
                            from PIL import Image
                            from io import BytesIO

                            # 이미지 파일 유효성 검사
                            image = Image.open(BytesIO(img_data))
                            image.verify()  # 이미지 유효성 확인

                            # 유효한 이미지인 경우 저장
                            with open(img_name, 'wb') as handler:
                                handler.write(img_data)
                            dress_counter += 1

                            print(f"Downloaded: {img_name}")
                            
                        except (IOError, SyntaxError) as e:
                            print(f"Invalid image file, skipping: {img_url} - {e}")

                    else:
                        print(f"Skipped short filename: {img_url}")
                else:
                    pass
            except Exception as e:
                print(f"Failed to download: {img_url} - {e}")

    # 드라이버 종료
    driver.quit()
