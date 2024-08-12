import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"

export function FIT() {
  return (
    <div className="container mx-auto px-4 py-8 max-w-3xl">
      <div className="grid gap-8">
        <div>
          <h1 className="text-3xl font-bold mb-4">가상 의류 피팅</h1>
          <p className="text-muted-foreground">
            사진을 업로드하고 샘플 이미지를 선택하여 옷을 가상으로 착용해 보세요.
          </p>
        </div>
        <div className="grid gap-6">
          <div>
            <Label htmlFor="photo">사진 업로드</Label>
            <Input id="photo" type="file" />
          </div>
          <div>
            <Label>샘플 이미지 선택</Label>
            <div className="grid grid-cols-5 gap-4">
              <button className="border rounded-md overflow-hidden">
                <img
                  src="/placeholder.svg"
                  alt="샘플 1"
                  width={120}
                  height={180}
                  className="object-cover"
                  style={{ aspectRatio: "120/180", objectFit: "cover" }}
                />
              </button>
              <button className="border rounded-md overflow-hidden">
                <img
                  src="/placeholder.svg"
                  alt="샘플 2"
                  width={120}
                  height={180}
                  className="object-cover"
                  style={{ aspectRatio: "120/180", objectFit: "cover" }}
                />
              </button>
              <button className="border rounded-md overflow-hidden">
                <img
                  src="/placeholder.svg"
                  alt="샘플 3"
                  width={120}
                  height={180}
                  className="object-cover"
                  style={{ aspectRatio: "120/180", objectFit: "cover" }}
                />
              </button>
              <button className="border rounded-md overflow-hidden">
                <img
                  src="/placeholder.svg"
                  alt="샘플 4"
                  width={120}
                  height={180}
                  className="object-cover"
                  style={{ aspectRatio: "120/180", objectFit: "cover" }}
                />
              </button>
              <button className="border rounded-md overflow-hidden">
                <img
                  src="/placeholder.svg"
                  alt="샘플 5"
                  width={120}
                  height={180}
                  className="object-cover"
                  style={{ aspectRatio: "120/180", objectFit: "cover" }}
                />
              </button>
            </div>
          </div>
        </div>
        <div className="bg-background border rounded-md p-6">
          <h2 className="text-2xl font-bold mb-4">가상 피팅 결과</h2>
          <div className="flex justify-center">
            <img
              src="/placeholder.svg"
              alt="가상 피팅"
              width={600}
              height={600}
              className="max-w-full"
              style={{ aspectRatio: "600/600", objectFit: "cover" }}
            />
          </div>
        </div>
      </div>
    </div>
  )
}