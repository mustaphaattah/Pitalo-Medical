import React from "react";
import { NavLink } from "react-router-dom";
import sprite from "./assets/sprite.svg";
import tailwind from './assets/tailwindcss-icon.svg';
import react from './assets/React-icon.svg';
import redux from './assets/redux logo.svg';
import spring from './assets/spring logo.svg';

export default function Home() {
  return (
    <div>
      <div id="hero" className="pt-8 pb-20 px-16">
        <nav className="flex justify-between items-baseline">
          <div className="flex items-center">
            <svg className="h-12 w-12">
              <use xlinkHref={`${sprite}#medicine`} />
            </svg>
            <NavLink to="/" className="text-4xl font-bold pl-3">
              Pitalo Medical
            </NavLink>
          </div>
          <div>
            <NavLink to="/patients" className="pl-16 text-lg">
              Patients
            </NavLink>
            <NavLink to="/" className="pl-16 text-lg">
              Staff
            </NavLink>
          </div>
        </nav>

        <div className="my-20 text-center">
          <h2 className="text-6xl font-bold">Premium Medical Services</h2>
          <p className="py-10 text-xl">
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Aspernatur nostrum unde necessitatibus.
            Corrupti tempore aperiam mollitia ut deserunt quaerat modi atque id, ab adipisci.
            Cumque dolorem esse accusamus consectetur cum suscipit delectus obcaecati natus illum laudantium,
            eaque reiciendis assumenda animi
          </p>
        </div>

        <NavLink to="/" className="flex items-center justify-center">
          <span className="text-2xl font-semibold bg-red-500 px-12 py-3 text-white">Login</span>
          <span className="bg-red-600 px-4 py-5 -mr-3">
            <svg className="h-5 w-5 fill-white">
              <use xlinkHref={`${sprite}#play-button`} />
            </svg>
          </span>
        </NavLink>
      </div>

      <div id="visits" className="flex bg-gray-200 py-16 px-16">
        <div className="flex-1 text-center flex flex-col items-center px-2">
          <svg className="h-12 w-12">
            <use xlinkHref={`${sprite}#birthday-and-party`} />
          </svg>
          <h3 className="font-semibold text-xl pt-4">WALK-IN</h3>
          <p className="px-8 text-gray-700">
            Get a consultation with a specialist upon walking in
          </p>
        </div>

        <div className="flex-1 text-center flex flex-col items-center px-2">
          <svg className="h-12 w-12">
            <use xlinkHref={`${sprite}#appointment`} />
          </svg>
          <h3 className="font-semibold text-xl pt-4">APPOINTMENT</h3>
          <p className="px-8 text-gray-700">
            Booking appointments made easy with no hassle
          </p>
        </div>

        <div className="flex-1 text-center flex flex-col items-center px-2">
          <svg className="h-12 w-12">
            <use xlinkHref={`${sprite}#first-aid-kit-1`} />
          </svg>
          <h3 className="font-semibold text-xl pt-4">EMERGENCY</h3>
          <p className="px-8 text-gray-700">
            Immediate Response to high, medium and low incidents
          </p>
        </div>
      </div>

      <div id="specialties" className="flex">
        <div className="w-1/2 py-20 px-16">
          <h3 className="font-bold text-4xl mb-3">Our Specialties</h3>
          <p className="text-xl">
            Our facility provides access to multiple specialists with modern technologies.

          </p>
        </div>

        <div className="w-1/2 py-20 px-16 bg-red-200">

          <div className="flex mb-12">
            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#heart`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">Cardiologist</h4>
            </div>

            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#first-aid-kit`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">Emergency Medical Specialist</h4>
            </div>
          </div>

          <div className="flex mb-12">
            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#pelvic-area`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">Obstetrician-Gynecologist</h4>
            </div>

            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#kidney`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">Nephrologist</h4>
            </div>
          </div>

          <div className="flex">
            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#girl`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">Pediatric Immunologist</h4>
            </div>

            <div className="flex-1 flex flex-col items-center">
              <svg className="h-12 w-12">
                <use xlinkHref={`${sprite}#doctor-3`} />
              </svg>
              <h4 className="font-semibold pt-3 text-red-900">General Practitioner</h4>
            </div>
          </div>

        </div>
      </div>

      <div id="built-with" className="bg-purple-100 py-8 px-16">
        <div className="flex justify-between items-center">
          <h3 className="text-3xl font-semibold">Built with:</h3>
          <img src={`${spring}`} alt="Spring Logo" className="h-12" />
          <img src={`${react}`} alt="React Logo" className="h-16" />
          <img src={`${redux}`} alt="Redux Logo" className="h-16" />
          <img src={`${tailwind}`} alt="Tailwind Logo" className="h-12" />
        </div>
      </div>

      <div id="footer" className="bg-purple-700 py-16 px-16">
        <div className="border-t-2 border-purple-200 text-center pt-6 text-purple-200">
          Built by Nur-sh. All rights reserved.
        </div>
      </div>
    </div>
  );
}
