from fastapi import FastAPI, File, UploadFile

app = FastAPI()

@app.post("/data")
async def post_data(image1: UploadFile = File(...), image2: UploadFile = File(...)):
    # 파일 내용을 읽습니다.
    content1 = await image1.read()
    content2 = await image2.read()

    # 디버깅을 위해 파일 세부 정보를 출력합니다.
    print(f"Received image1: {image1.filename}, size: {len(content1)} bytes")
    print(f"Received image2: {image2.filename}, size: {len(content2)} bytes")


    # model running

    # 파일 정보를 반환합니다 (예: 파일 이름 및 크기)
    return {
        "message": "Images received successfully",
        "image1": {"filename": image1.filename, "size": len(content1)},
        "image2": {"filename": image2.filename, "size": len(content2)}
    }
