import React from "react";
import { Badge } from "@/components/ui/badge"
import { Label } from "@/components/ui/label"
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from "@/components/ui/select"
import { Button } from "@/components/ui/button"

export function DETAIL() {
  return (
    <div className="flex flex-col md:flex-row w-full max-w-5xl mx-auto p-4">
      <div className="w-full md:w-1/2">
        <img
          src="/placeholder.svg"
          alt="Product Image"
          className="w-full h-auto"
          width="500"
          height="500"
          style={{ aspectRatio: "500/500", objectFit: "cover" }}
        />
        <div className="flex justify-center mt-4 space-x-2">
          <img
            src="/placeholder.svg"
            alt="Thumbnail 1"
            className="w-16 h-16"
            width="100"
            height="100"
            style={{ aspectRatio: "100/100", objectFit: "cover" }}
          />
          <img
            src="/placeholder.svg"
            alt="Thumbnail 2"
            className="w-16 h-16"
            width="100"
            height="100"
            style={{ aspectRatio: "100/100", objectFit: "cover" }}
          />
          <img
            src="/placeholder.svg"
            alt="Thumbnail 3"
            className="w-16 h-16"
            width="100"
            height="100"
            style={{ aspectRatio: "100/100", objectFit: "cover" }}
          />
          <img
            src="/placeholder.svg"
            alt="Thumbnail 4"
            className="w-16 h-16"
            width="100"
            height="100"
            style={{ aspectRatio: "100/100", objectFit: "cover" }}
          />
        </div>
      </div>
      <div className="w-full md:w-1/2 md:pl-8 mt-8 md:mt-0">
        <h1 className="text-2xl font-bold mb-2">짱멋있는 티셔츠</h1>
        <div className="space-y-2">
          <div className="flex justify-between items-center">
            <span className="text-muted-foreground">판매가</span>
            <span className="line-through">29,900₩</span>
            <Badge variant="secondary">10% OFF</Badge>
          </div>
          <div className="flex justify-between items-center">
            <span className="text-muted-foreground">할인판매가</span>
            <span className="text-red-500 font-bold">26,910₩</span>
          </div>
          <div className="flex justify-between items-center">
            <span className="text-muted-foreground">배송비</span>
            <span>무료</span>
          </div>
        </div>
        <div className="mt-4 space-y-4">
          <div>
            <Label htmlFor="color">색상</Label>
            <Select>
              <SelectTrigger id="color" aria-label="Color">
                <SelectValue placeholder="[필수] 옵션을 선택해 주세요." />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="black">Black</SelectItem>
                <SelectItem value="blue">Blue</SelectItem>
                <SelectItem value="white">White</SelectItem>
              </SelectContent>
            </Select>
          </div>
          <div>
            <Label htmlFor="size">사이즈</Label>
            <Select>
              <SelectTrigger id="size" aria-label="Size">
                <SelectValue placeholder="[필수] 옵션을 선택해 주세요." />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="small">-S-</SelectItem>
                <SelectItem value="medium">-M-</SelectItem>
                <SelectItem value="large">-L-</SelectItem>
              </SelectContent>
            </Select>
          </div>
        </div>
        <div className="mt-4 text-sm text-muted-foreground">최소주문수량 1개 이상</div>
        <div className="mt-4 flex justify-between items-center">
          <span className="font-bold">TOTAL: 0 (0개)</span>
        </div>
        <div className="mt-4 flex space-x-2">
          <Button variant="outline" className="flex-1">
            <HeartIcon className="w-5 h-5 mr-2" />
            찜
          </Button>
          <Button className="flex-1">바로구매</Button>
        </div>
        <div className="mt-4 flex space-x-2">
          <Button variant="secondary" className="flex-1">
            <ShoppingCartIcon className="w-5 h-5 mr-2" />
            N PAY 구매
          </Button>
        </div>
        <div className="mt-4 flex space-x-2">
          <Button variant="link" className="flex-1">
            <FacebookIcon className="w-5 h-5" />
          </Button>
          <Button variant="link" className="flex-1">
            <TwitterIcon className="w-5 h-5" />
          </Button>
        </div>
      </div>
    </div>
  )
}

function FacebookIcon(props: React.SVGProps<SVGSVGElement>) {
  return (
    <svg
      {...props}
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z" />
    </svg>
  )
}


function HeartIcon(props: React.SVGProps<SVGSVGElement>) {
  return (
    <svg
      {...props}
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      <path d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z" />
    </svg>
  )
}


function ShoppingCartIcon(props: React.SVGProps<SVGSVGElement>) {
  return (
    <svg
      {...props}
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      <circle cx="8" cy="21" r="1" />
      <circle cx="19" cy="21" r="1" />
      <path d="M2.05 2.05h2l2.66 12.42a2 2 0 0 0 2 1.58h9.78a2 2 0 0 0 1.95-1.57l1.65-7.43H5.12" />
    </svg>
  )
}


function TwitterIcon(props: React.SVGProps<SVGSVGElement>) {
  return (
    <svg
      {...props}
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      <path d="M22 4s-.7 2.1-2 3.4c1.6 10-9.4 17.3-18 11.6 2.2.1 4.4-.6 6-2C3 15.5.5 9.6 3 5c2.2 2.6 5.6 4.1 9 4-.9-4.2 4-6.6 7-3.8 1.1 0 3-1.2 3-1.2z" />
    </svg>
  )
}
