@import gg.jte.Content
@param Content content
@param String title = "Default"



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-800">

<div class="flex flex-col h-screen">
<!-- Header Section -->
<header class="mb-2 px-4 shadow bg-white">
    <div class="relative mx-auto flex max-w-screen-xl flex-col py-4 sm:flex-row sm:items-center sm:justify-between" >
        <a class="flex items-center text-2xl font-black me-auto" href="/">
      <span class="mr-2 text-3xl text-blue-600"
      ><svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="img" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="currentColor" d="M6.925 16.875Q5.2 16.225 4.1 14.713Q3 13.2 3 11.25q0-1.975.938-3.513Q4.875 6.2 6 5.15q1.125-1.05 2.062-1.6L9 3v2.475q0 .625.45 1.062q.45.438 1.075.438q.35 0 .65-.15q.3-.15.5-.425L12 6q.95.55 1.625 1.35t1.025 1.8l-1.675 1.675q-.05-.6-.287-1.175q-.238-.575-.638-1.05q-.35.2-.738.287q-.387.088-.787.088q-1.1 0-1.987-.612Q7.65 7.75 7.25 6.725q-.95.925-1.6 2.062Q5 9.925 5 11.25q0 .775.275 1.462q.275.688.75 1.213q.05-.5.287-.938q.238-.437.588-.787L9 10.1l2.15 2.1q.05.05.1.125t.1.125l-1.425 1.425q-.05-.075-.087-.125q-.038-.05-.088-.1L9 12.925l-.7.7q-.125.125-.212.287q-.088.163-.088.363q0 .3.175.537q.175.238.45.363ZM9 10.1Zm0 0ZM7.4 22L6 20.6L19.6 7L21 8.4L17.4 12H21v2h-5.6l-.5.5l1.5 1.5H21v2h-2.6l2.1 2.1l-1.4 1.4l-2.1-2.1V22h-2v-4.6l-1.5-1.5l-.5.5V22h-2v-3.6Z" /></svg
          ></span>
            <span>future</span>
        </a>

        <input class="peer hidden" type="checkbox" id="navbar-open" />
        <label class="absolute right-0 mt-1 cursor-pointer text-xl sm:hidden" for="navbar-open">
            <span class="sr-only">Toggle Navigation</span>
            <svg xmlns="http://www.w3.org/2000/svg" width="0.88em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 448 512"><path fill="currentColor" d="M0 96c0-17.7 14.3-32 32-32h384c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zm0 160c0-17.7 14.3-32 32-32h384c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zm448 160c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32h384c17.7 0 32 14.3 32 32z" /></svg>
        </label>
        <nav aria-label="Header Navigation" class="peer-checked:block hidden pl-2 py-6 sm:block sm:py-0">
            <ul class="flex flex-col  sm:flex-row sm:gap-x-8">
                <li class=""><a class="text-gray-600 hover:text-blue-600 py-3 sm:py-0 block text-center hover:bg-emerald-100 md:hover:bg-white" href="#">Pricing</a></li>
                <li class=""><a class="text-gray-600 hover:text-blue-600 py-3 sm:py-0 block text-center hover:bg-emerald-200 md:hover:bg-white" href="#">Demo</a></li>
                <li class=""><a class="text-gray-600 hover:text-blue-600 py-3 sm:py-0 block text-center hover:bg-emerald-300 md:hover:bg-white" href="#">Support</a></li>
                <li class="mt-2 sm:mt-0"><a class="rounded-xl border-2 border-blue-600 px-6 py-2 font-medium text-blue-600 hover:bg-blue-600 hover:text-white" href="#">Login</a></li>
            </ul>
        </nav>
    </div>
</header>


<!-- Main Content -->
<main class="flex-grow max-w-screen-xl container mx-auto px-4 py-10">
    <div class="bg-white shadow p-3 rounded-xl">
    ${content}
    </div>
</main>

<!-- Footer Section -->
<footer class="relative mt-20 bg-gray-900 px-4 pt-20">

    <nav aria-label="Footer Navigation" class="mx-auto mb-10 flex max-w-lg flex-col gap-10 text-center sm:flex-row sm:text-left">
        <a href="#" class="font-medium text-white">Demo</a>
        <a href="#" class="font-medium text-white">Support</a>
        <a href="#" class="font-medium text-white">Privacy Policy</a>
        <a href="#" class="font-medium text-white">Terms & Conditions</a>
    </nav>
    <p class="py-10 text-center text-gray-300">© 2022 Boleno | All Rights Reserved</p>
</footer>

</div>
</body>
</html>