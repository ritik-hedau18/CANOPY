/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        dark: {
          900: '#07090E',
          800: '#0D1117',
          700: '#161B22',
          600: '#21262D'
        },
        saas: {
          emerald: '#10B981',
          teal: '#14B8A6',
          indigo: '#6366F1'
        }
      }
    },
  },
  plugins: [],
}

// minor tweak: update verification rules and configs
