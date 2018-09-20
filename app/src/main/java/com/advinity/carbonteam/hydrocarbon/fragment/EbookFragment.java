package com.advinity.carbonteam.hydrocarbon.fragment;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.adapter.EbookAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Ebook;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookFragment extends Fragment {

    private ImageView thumbnail;
    private RecyclerView recyclerView;
    private EbookAdapter adapter;
    private List<Ebook> ebookList;

    public EbookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ebook, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.ebook_recyclerview);

        ebookList = new ArrayList<>();
        adapter = new EbookAdapter(getContext(), ebookList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(12), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareEbook();

        return view;
    }

    private int dpToPx(int dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics()));
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private void prepareEbook() {
        // drawable -> thumb_ebook -> thumb_ebook_*
        int[] cover = new int[] {
                R.drawable.thumb_ebook_1,
                R.drawable.thumb_ebook_2,
                R.drawable.thumb_ebook_3,
                R.drawable.thumb_ebook_4,
                R.drawable.thumb_ebook_5,
                R.drawable.thumb_ebook_6,
                R.drawable.thumb_ebook_7,
                R.drawable.thumb_ebook_8
        };

        // drawable -> img_ebook -> img_ebook_*
        int[] image = new int[] {
                R.drawable.img_ebook_1,
                R.drawable.img_ebook_2,
                R.drawable.img_ebook_3,
                R.drawable.img_ebook_4,
                R.drawable.img_ebook_5,
                R.drawable.img_ebook_6,
                R.drawable.img_ebook_7,
                R.drawable.img_ebook_8
        };

        Ebook ebook = new Ebook(
                "Basic Physical Chemistry",
                "A complete introduction on bachelor of science level",
                "Dr Wolfgang Schartl",
                cover[0],
                image[0],
                "1st Edition",
                "Copyright © 2014",
                "What is Physical Chemistry? Simply spoken, it is a scientific branch located between Physics and " +
                        "Chemistry. By using the principles of physics and mathematics to obtain quantitative relations, physical " +
                        "chemistry deals with the structure and dynamics of matter. These relations are, in most cases, either " +
                        "concerned with phase and chemical equilibrium, or dynamic processes such as phase transitions, reaction " +
                        "kinetics, charge transport, and energy exchange between systems and surroundings.",
                "http://afdolash18.it.student.pens.ac.id/basic-physical-chemistry.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Chemical Engineering Vocabulary",
                "-",
                "Maximilian Lackner",
                cover[1],
                image[1],
                "2nd Edition",
                "Copyright © 2014",
                "The Chemical Engineering Vocabulary was written for students and young professionals in chemistry, " +
                        "mechanical engineering, chemical engineering and economics, who have to do with chemical engineering " +
                        "in an academic or industrial setting.\n\nAll entries come with a sentence, which shows the application and, in addition, provides a piece of " +
                        "relevant and interesting information. In contrast to common dictionaries, this book does not have trivial " +
                        "entries (e.g. filter/Filter, metal/Metall, vacuum/Vakuum, project/Projekt). Only terms that are relevant " +
                        "for work, 2600, were selected.",
                "http://afdolash18.it.student.pens.ac.id/chemical-engineering-vocabulary.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Chemical Engineering Vocabulary",
                "-",
                "Maximilian Lackner",
                cover[2],
                image[2],
                "1st Edition",
                "Copyright © 2016",
                "The Chemical Engineering Vocabulary was written for students and young professionals in chemistry, " +
                        "mechanical engineering, chemical engineering and economics, who have to do with chemical engineering " +
                        "in an academic or industrial setting.\n\nAll entries come with a sentence, which shows the application and, in addition, provides a piece of " +
                        "relevant and interesting information. In contrast to common dictionaries, this book does not have trivial " +
                        "entries (e.g. filter/Filter, metal/Metall, vacuum/Vakuum, project/Projekt). Only terms that are relevant " +
                        "for work, 2600, were selected.",
                "http://afdolash18.it.student.pens.ac.id/chemical-engineering-vocabulary-2016.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Essentials of Chemistry",
                "-",
                "Soren Prip Beier & Peter Dybdahl Hede",
                cover[3],
                image[3],
                "3rd Edition",
                "Copyright © 2013",
                "This book is written primarily to engineering students in the fields of basic chemistry, environmental " +
                        "chemistry, food production, chemical and biochemical engineering who in the beginning of their " +
                        "university studies receive education in inorganic chemistry and applied chemistry in general.\n\n" +
                        "The aim of this book is to explain and clarify important terms and concepts which the students are " +
                        "supposed to be familiar with. The book can not replace existing educational textbooks, but it gives a " +
                        "great supplement to the education within chemistry. Many smaller assignments and examples including " +
                        "solutions are given in the book.",
                "http://afdolash18.it.student.pens.ac.id/chemistry.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Essential Descriptive Inorganic Chemistry",
                "What every chemistry student should know",
                "Peter G. Nelson",
                cover[4],
                image[4],
                "1st Edition",
                "Copyright © 2016",
                "Educators have responded to this by arguing that what students need to do is not learn " +
                        "facts but the principles and theories behind the facts. The problem with this approach is " +
                        "that chemical principles and theories are not good enough for this. They only explain a " +
                        "small fraction of all the facts. Teaching principles and theories without any facts therefore " +
                        "leaves students ignorant of many of the facts, including very basic ones.",
                "http://afdolash18.it.student.pens.ac.id/essential-descriptive-inorganic-chemistry.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Hydrocarbons",
                "Physical properties and their relevance to utilisation",
                "Dr Clifford Jones",
                cover[5],
                image[5],
                "1st Edition",
                "Copyright © 2010",
                "Can a book of 100 pages possibly have a place in an area as vast and as complex as hydrocarbon science " +
                        "and technology? I believe that it can. It is an ill-informed judgement of a piece of scholarship which " +
                        "equates brevity with superficiality. This book is very focused and is intended to bring out new perspectives " +
                        "rather than to reproduce information readily available elsewhere. It is to that, not to any deficiency in " +
                        "content, that the book owes its modest length.",
                "http://afdolash18.it.student.pens.ac.id/hydrocarbons.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Introduction to Inorganic Chemistry",
                "Key ideas and their experimental basis",
                "Peter G. Nelson",
                cover[6],
                image[6],
                "-",
                "Copyright © 2011",
                "Organic chemistry is usually defined as the chemistry of compounds of carbon, inorganic chemistry being " +
                        "then the chemistry of all the other elements. This distinction is not a completely satisfactory one, however, " +
                        "since there are many compounds of carbon that are quite different from those studied by organic chemists " +
                        "(e.g. tungsten carbide, used for tipping cutting tools) and there are many compounds of other elements that " +
                        "are very similar to those studied under organic chemistry (e.g. the silicon analogues of the hydrocarbons). " +
                        "It is best, therefore, to think of inorganic chemistry as the chemistry of all the elements, with organic " +
                        "chemistry as being a more detailed study of certain important aspects of one of them - viz. the " +
                        "hydrocarbons and their derivatives.",
                "http://afdolash18.it.student.pens.ac.id/introduction-to-inorganic-chemistry.pdf"
        );
        ebookList.add(ebook);

        ebook = new Ebook(
                "Introduction Chemistry",
                "-",
                "Edward W. Pitzer",
                cover[7],
                image[7],
                "1st Edition",
                "Copyright © 2014",
                "This textbook is intended for use by college level students who will take only one course in chemistry " +
                        "throughout their academic career.\n\nAll of the problems presented in this text all fully worked with proper and correct answers. Do yourself a " +
                        "favor. Write the statement of the problems on a piece of paper, exit the text, and try to solve the problems. " +
                        "If you get stuck on a problem, refer back to the text. After several trials of the problems in this fashion " +
                        "you will probably find you have mastered the material.",
                "http://afdolash18.it.student.pens.ac.id/introductory-chemistry.pdf"
        );
        ebookList.add(ebook);

        adapter.notifyDataSetChanged();
    }
}