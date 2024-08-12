import { DETAIL } from "@/components/detail";
import { FIT } from "@/components/fit";
import { HOME } from "@/components/home";

import Image from "next/image";

export default function Home() {
  return (
    <>
      <HOME />
      <FIT />
      <DETAIL />
    </>
  );
}