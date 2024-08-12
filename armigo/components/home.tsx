import React from "react";
import Link from "next/link"
import { Input } from "@/components/ui/input"
import { Badge } from "@/components/ui/badge"
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar"
import { Separator } from "@/components/ui/separator"
import { Label } from "@/components/ui/label"
import { Toggle} from "@/components/ui/toggle"
import { Button } from "@/components/ui/button"

export function HOME() {
  return (
    <div className="flex flex-col min-h-screen">
      <header className="bg-white shadow-sm">
        <div className="container mx-auto px-4 py-4 flex items-center justify-between">
          <Link href="#" className="flex items-center gap-2" prefetch={false}>
            <MountainIcon className="h-8 w-8 text-primary" />
            <span className="text-xl font-bold">Armigo</span>
          </Link>
          <div className="relative w-full max-w-md">
            <SearchIcon className="absolute left-3 top-1/2 -translate-y-1/2 h-5 w-5 text-muted-foreground" />
            <Input
              type="search"
              placeholder="Search products..."
              className="pl-10 pr-4 py-2 rounded-lg bg-muted w-full"
            />
          </div>
          <div className="flex items-center gap-4">
            <Link href="#" className="relative" prefetch={false}>
              <ShoppingCartIcon className="h-6 w-6 text-muted-foreground" />
              <Badge className="absolute -top-2 -right-2 bg-primary text-primary-foreground px-1.5 py-0.5 rounded-full text-xs">
                3
              </Badge>
            </Link>
            <Link href="#" className="flex items-center gap-2" prefetch={false}>
              <Avatar className="w-8 h-8 border">
                <AvatarImage src="/placeholder-user.jpg" alt="User Avatar" />
                <AvatarFallback>JD</AvatarFallback>
              </Avatar>
              <span className="text-muted-foreground">UserName</span>
            </Link>
          </div>
        </div>
      </header>
      <main className="flex-1 bg-muted/20 py-8">
        <div className="container mx-auto px-4 grid grid-cols-1 md:grid-cols-[260px_1fr] gap-8">
          <div className="bg-white rounded-lg shadow-sm p-6">
            <h2 className="text-lg font-bold mb-4">카테고리</h2>
            <nav className="grid gap-2">
              <Link href="#" className="flex items-center justify-between hover:text-primary" prefetch={false}>
                <span>상의</span>
                <ChevronRightIcon className="h-5 w-5 text-muted-foreground" />
              </Link>
              <Link href="#" className="flex items-center justify-between hover:text-primary" prefetch={false}>
                <span>하의</span>
                <ChevronRightIcon className="h-5 w-5 text-muted-foreground" />
              </Link>
              <Link href="#" className="flex items-center justify-between hover:text-primary" prefetch={false}>
                <span>원피스/스커트</span>
                <ChevronRightIcon className="h-5 w-5 text-muted-foreground" />
              </Link>
              <Link href="#" className="flex items-center justify-between hover:text-primary" prefetch={false}>
                <span>뷰티</span>
                <ChevronRightIcon className="h-5 w-5 text-muted-foreground" />
              </Link>
            </nav>
            <Separator className="my-6" />
            <h2 className="text-lg font-bold mb-4">필터</h2>
            <div className="grid gap-4">
              <div>
                <Label htmlFor="price-range">가격</Label>
                <div className="mt-2" />
              </div>
              <div>
                <Label htmlFor="size">사이즈</Label>
                <div className="mt-2 flex flex-wrap gap-2">
                  <Toggle>XS</Toggle>
                  <Toggle>S</Toggle>
                  <Toggle>M</Toggle>
                  <Toggle>L</Toggle>
                  <Toggle>XL</Toggle>
                </div>
              </div>
              <div>
                <Label htmlFor="color">색상</Label>
                <div className="mt-2 flex flex-wrap gap-2">
                  <Toggle className="w-8 h-8 bg-black rounded-full" />
                  <Toggle className="w-8 h-8 bg-white rounded-full border" />
                  <Toggle className="w-8 h-8 bg-red-500 rounded-full" />
                  <Toggle className="w-8 h-8 bg-blue-500 rounded-full" />
                  <Toggle className="w-8 h-8 bg-green-500 rounded-full" />
                </div>
              </div>
            </div>
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img src="/placeholder.svg" alt="Product Image" width={400} height={500} className="w-full h-64 object-cover" style={{ aspectRatio: "400/500", objectFit: "cover" }} />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">짱멋있는 티셔츠</h3>
                  <p className="text-muted-foreground line-clamp-2">입으면 따뜻하다..</p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">29,900₩</span>
                  <Button size="sm" variant="outline">장바구니에 담기</Button>
                </div>
              </div>
            </div>
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img
                  src="/placeholder.svg"
                  alt="Product Image"
                  width={400}
                  height={500}
                  className="w-full h-64 object-cover"
                  style={{ aspectRatio: "400/500", objectFit: "cover" }}
                />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">개쩌는 청바지</h3>
                  <p className="text-muted-foreground line-clamp-2">
                    멋쟁이가 되어보자
                  </p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">49,900₩</span>
                  <Button size="sm" variant="outline">
                    장바구니에 담기
                  </Button>
                </div>
              </div>
            </div>
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img
                  src="/placeholder.svg"
                  alt="Product Image"
                  width={400}
                  height={500}
                  className="w-full h-64 object-cover"
                  style={{ aspectRatio: "400/500", objectFit: "cover" }}
                />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">엘레강스한 드레스</h3>
                  <p className="text-muted-foreground line-clamp-2">
                    당신도 뉴진스 하니가 될 수 있다..!
                  </p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">79,900₩</span>
                  <Button size="sm" variant="outline">
                    장바구니에 담기
                  </Button>
                </div>
              </div>
            </div>
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img
                  src="/placeholder.svg"
                  alt="Product Image"
                  width={400}
                  height={500}
                  className="w-full h-64 object-cover"
                  style={{ aspectRatio: "400/500", objectFit: "cover" }}
                />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">아늑한 스웨터</h3>
                  <p className="text-muted-foreground line-clamp-2">
                    이것만 입으면 당신도 공돌이 탈출?!
                  </p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">39,900₩</span>
                  <Button size="sm" variant="outline">
                    장바구니에 담기
                  </Button>
                </div>
              </div>
            </div>
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img
                  src="/placeholder.svg"
                  alt="Product Image"
                  width={400}
                  height={500}
                  className="w-full h-64 object-cover"
                  style={{ aspectRatio: "400/500", objectFit: "cover" }}
                />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">귀걸이</h3>
                  <p className="text-muted-foreground line-clamp-2">
                    평범한 귀걸이다..
                  </p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">19,900₩</span>
                  <Button size="sm" variant="outline">
                    장바구니에 담기
                  </Button>
                </div>
              </div>
            </div>
            <div className="bg-white rounded-lg shadow-sm overflow-hidden">
              <Link href="#" className="block" prefetch={false}>
                <img
                  src="/placeholder.svg"
                  alt="Product Image"
                  width={400}
                  height={500}
                  className="w-full h-64 object-cover"
                  style={{ aspectRatio: "400/500", objectFit: "cover" }}
                />
              </Link>
              <div className="p-4">
                <Link href="#" className="block" prefetch={false}>
                  <h3 className="text-lg font-bold mb-2">하늘하늘 블라우스</h3>
                  <p className="text-muted-foreground line-clamp-2">
                    제가 누군가를 좋아한다는 사실이 그 사람에겐 상처가 될 수도 있잖아요
                  </p>
                </Link>
                <div className="flex items-center justify-between mt-4">
                  <span className="text-xl font-bold">34,900₩</span>
                  <Button size="sm" variant="outline">
                    장바구니에 담기
                  </Button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
      <footer className="bg-white border-t">
        <div className="container mx-auto px-4 py-6 flex items-center justify-between">
          <div className="flex items-center gap-2">
            <MountainIcon className="h-6 w-6 text-primary" />
            <span className="text-lg font-bold">Armigo</span>
          </div>
          <div className="flex items-center gap-4 text-muted-foreground">
            <Link href="#" prefetch={false}>Terms of Service</Link>
            <Link href="#" prefetch={false}>Privacy Policy</Link>
            <Link href="#" prefetch={false}>Contact Us</Link>
          </div>
        </div>
      </footer>
    </div>
  );
}

function ChevronRightIcon(props: React.SVGProps<SVGSVGElement>) {
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
      <path d="m9 18 6-6-6-6" />
    </svg>
  )
}


function MountainIcon(props: React.SVGProps<SVGSVGElement>) {
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
      <path d="m8 3 4 8 5-5 5 15H2L8 3z" />
    </svg>
  )
}


function SearchIcon(props: React.SVGProps<SVGSVGElement>) {
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
      <circle cx="11" cy="11" r="8" />
      <path d="m21 21-4.3-4.3" />
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
